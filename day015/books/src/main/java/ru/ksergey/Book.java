package ru.ksergey;

import lombok.*;

@Data
public class Book {
    private long id;
    private String title;
    private String author;
    private String description;
}
