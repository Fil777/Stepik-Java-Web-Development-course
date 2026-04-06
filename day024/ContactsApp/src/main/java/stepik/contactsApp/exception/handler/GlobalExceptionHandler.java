package stepik.contactsApp.exception.handler;

import stepik.contactsApp.common.util.ServerResponseHelper;
import stepik.contactsApp.model.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

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

        return ServerResponseHelper.conflict(null, errors);
    }
}
