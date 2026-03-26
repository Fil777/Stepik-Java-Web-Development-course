package ru.ksergey;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        int count = 3;

        ArrayList<Book> books = generateBooks(count);

        for (int i = 0; i < count; i++) {
            System.out.println(books.get(i));
        }
    }

    static ArrayList<Book> generateBooks(int count) {
        ArrayList<Book> books = new ArrayList<>();

        Faker faker = new Faker(Locale.of("en"));

        for (int i = 0; i < count; i++) {
            Book book = new Book();

            book.setId(faker.number().randomNumber());
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setDescription(faker.lorem().paragraph());

            books.add(book);
        }

        return books;
    }
}