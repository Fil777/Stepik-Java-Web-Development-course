package ru.ksergey.contactApp.exception.customException;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
