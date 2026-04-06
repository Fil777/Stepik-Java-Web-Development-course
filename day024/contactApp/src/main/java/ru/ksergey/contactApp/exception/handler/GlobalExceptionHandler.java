package ru.ksergey.contactApp.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;

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
}