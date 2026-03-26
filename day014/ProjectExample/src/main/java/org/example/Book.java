package org.example;

import lombok.Data;

import java.util.Objects;

@Data
public class Book {
    private String title;
    private int yearPublished;


    public Book(String title, int yearPublished) {
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return yearPublished == book.yearPublished && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, yearPublished);
    }
}
