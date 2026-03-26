package org.example;


import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

public class Main {

    static ArrayList<Book> generateBooks(int count){
        ArrayList<Book> books = new ArrayList<>();

        Faker faker = new Faker(Locale.of("ru"));

        for (int i = 0; i < count; i++){
            Book book = new Book(
                    faker.book().title(),
                    faker.number().numberBetween(2000, 2026));
            books.add(book);
        }

        return books;
    }

    public static void main(String[] args) {

        ArrayList<Book> books = generateBooks(10);
        books.forEach(book -> System.out.println(book.toString()));

    }
}