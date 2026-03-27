package org.example;

enum DayTime {
    MORNING("Доброе утро"),
    AFTERNOON("Добрый день"),
    EVENING("Добрый вечер"),
    NIGHT("Доброй ночи");

    private String message;

    DayTime(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
