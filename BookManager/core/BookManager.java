package core;

import java.util.ArrayList;
import java.util.HashMap;

public class BookManager {
    public static ArrayList<String> books = new ArrayList<>();
    public static HashMap<String, ArrayList<String>> users = new HashMap<>();

    static void addBook(String book) {
        books.add(book);
    }

    public static void removeBook(String book) {
        books.remove(book);
    }

    public static String searchBook(String book) {
        for (String bookTitle : books) {
            if (bookTitle.toLowerCase().contains(book.toLowerCase())) {
                return bookTitle;
            }
        }
        for (String bookTitle : users.values()) {
            if (bookTitle.toLowerCase().contains(book.toLowerCase())) {
                return bookTitle;
            }
        }
        return null;
    }

    public static void displayAllBooks() {
        for (String book : books) {
            writeLine(book);
        }
        for (String book : users.values()) {
            writeLine(book);
        }
    }

    public static void addUser(String name) {
        users.put(name, new ArrayList<>());
    }

    public static void removeUser(String name) {
        users.remove(name);
    }

    public static String getUserByName(String name) {
        for (String user : users.keySet()) {
            if (user.toLowerCase().contains(name.toLowerCase())) {
                return user;
            }
        }
        return null;
    }

    public static void displayUserBooks(String name) {
        for (String book : users.get(name)) {
            writeLine(book);
        }
    }

    public static void borrowBook(String name, String book) {
        users.get(name).add(book);
        removeBook(book);
    }

    public static void returnBook(String name, String book) {
        if (getUserByName(name) != null) {
            if (users.get(name).contains(book)) {
                users.get(name).remove(book);
                books.add(book);
            }
        }
    }

    public static boolean isBookAvailable(String book) {
        return books.contains(book);
    }

}
