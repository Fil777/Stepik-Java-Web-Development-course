package stepik.contactsApp.exception.handler;

import org.hibernate.LazyInitializationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import stepik.contactsApp.common.utils.serverresponse.ServerResponseHelper;
import stepik.contactsApp.exception.handler.customException.EntityNotFoundException;
import stepik.contactsApp.exception.handler.customException.ValidationException;
import stepik.contactsApp.model.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerResponse<Void>> handleValidationException(
            MethodArgumentNotValidException ex
    ){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> String.format("%s: %s",
                        err.getField(), err.getDefaultMessage()))
        .toList();

        return ServerResponseHelper.conflict(errors);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServerResponse<Void>> handleEntityValidationError(
            ValidationException ex){
        return ServerResponseHelper.conflict(null,ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ServerResponse<Void>> handleEntityNotFound(
            EntityNotFoundException ex){
        return ServerResponseHelper.conflict(null, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponse<Void>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {
        return ServerResponseHelper.conflict(null, ex.getMessage());
    }

    @ExceptionHandler(LazyInitializationException.class)
    public ResponseEntity<ServerResponse<Void>> handleLazyInitialization(
            LazyInitializationException ex) {
        return ServerResponseHelper.conflict(null, ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ServerResponse<Void>> handleOtherExceptions(
            UsernameNotFoundException ex) {
        return ServerResponseHelper.conflict(null, ex.getMessage());
    }

}
