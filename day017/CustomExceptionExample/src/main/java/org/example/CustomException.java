package ru.ksergey;

public class CustomException {
    public static void main(String[] args) {
        throw new MyException("Моя ошибка", 123456);
    }
}

class MyException extends RuntimeException {
    int errorId;

    public MyException(String message, int errorId) {
        super(message);
        this.errorId = errorId;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + "error code = " + errorId + ")";
    }
}