package ru.ksergey.contactApp.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.exception.customException.EntityNotFoundException;
import ru.ksergey.contactApp.exception.customException.ValidationException;
import ru.ksergey.contactApp.model.ServerResponse;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponse<Void>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> String.format("%s: %s",
                        error.getField(), error.getDefaultMessage()))
                .toList();

        return ServerResponseHelper.conflict(null, errors);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ServerResponse<Void>> handleEntityNotFound(
            EntityNotFoundException ex) {
        return ServerResponseHelper.notFound(null,
                Collections.singletonList(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServerResponse<Void>> handleValidationError(
            ValidationException ex) {
        return ServerResponseHelper.conflict(null,
                Collections.singletonList(ex.getMessage()));
    }
}