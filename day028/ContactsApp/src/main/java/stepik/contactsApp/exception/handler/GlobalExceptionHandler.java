package stepik.contactsApp.exception.handler;

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
            MethodArgumentNotValidException exc
    ){
        List<String> errors = exc.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> String.format("%s: %s",
                        err.getField(), err.getDefaultMessage()))
        .toList();

        return ServerResponseHelper.conflict(errors);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServerResponse<Void>> handlerEntityValidationError(
            ValidationException exc){
        return ServerResponseHelper.conflict(null,exc.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ServerResponse<Void>> handlerEntityNotFound(
            EntityNotFoundException exc){
        return ServerResponseHelper.conflict(null, exc.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponse<Void>> handlerEntityNotFound(
            MethodArgumentNotValidException exc) {
        return ServerResponseHelper.conflict(null, exc.getMessage());
    }

}
