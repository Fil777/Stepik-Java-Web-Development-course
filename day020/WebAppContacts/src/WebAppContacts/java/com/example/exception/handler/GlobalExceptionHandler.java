package com.example.exception.handler;

import com.example.common.util.ServerResponseHelper;
import com.example.model.ServerResponse;
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
