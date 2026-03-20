package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BookManager {
    private static ArrayList<String> books = new ArrayList<>();
    private static HashMap<String, ArrayList<String>> users = new HashMap<>();

    public static void addBook(String bookName) {
        books.add(bookName);
    }

    public static void removeBook(String bookName) {
        if (books.contains(bookName)) {
            books.remove(bookName);
            for (ArrayList<String> userBook : users.values()) {
                userBook.remove(bookName);
            }
        } else {
            Terminal.writeLine("Книга не найдена");
        }
    }

    public static void searchBook(String searchBook) {
        for (String book : books) {
            if (book.contains(searchBook)) {
                Terminal.writeLine("  >> " + book);
            }
        }
    }

    public static void displayAllBooks() {
        Terminal.writeLine("Все книги в библиотеке: ");
        for (String bookName : books) {
            Terminal.writeLine("  >> " + bookName);
        }
    }

    public static void addUser(String username) {
        if (!users.containsKey(username)) {
            users.put(username, new ArrayList<>());
        } else {
            Terminal.writeLine("Пользователь зарегистрирован.");
        }
    }

    public static void removeUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
        } else {
            Terminal.writeLine("Пользователь не найден");
        }
    }

    public static void displayAllUsers() {
        Terminal.writeLine("Все пользователи:");
        for (String user : users.keySet()) {
            Terminal.writeLine("  >> " + user);
        }
    }

    public static void displayUserBooks(String username) {
        if (users.containsKey(username)) {
            ArrayList<String> userBooks = users.get(username);

            Terminal.writeLine("Книги пользователя " + username + ": ");
            for (String book : userBooks) {
                Terminal.writeLine("  >> " + book);
            }

        } else {
            Terminal.writeLine("Пользователь не найден");
        }
    }

    public static void borrowBook(String username, String book) {
        if (isBookAvailable(book)) {
            if (users.containsKey(username)) {
                users.get(username).add(book);
                Terminal.writeLine("Книга " + book + " добавлена пользователю " + username);
            } else {
                Terminal.writeLine("Пользователь не найден");
            }
        } else {
            Terminal.writeLine("Книга не найдена");
        }
    }

    public static void returnBook(String username, String book) {
        if (isBookAvailable(book)) {
            if (users.containsKey(username)) {
                if (users.get(username).contains(book)) {
                    users.get(username).remove(book);
                    Terminal.writeLine("Книга " + book + " удалена у пользователя " + username);
                }
            } else {
                Terminal.writeLine("Пользователь не найден");
            }
        } else {
            Terminal.writeLine("Книга не найдена");
        }
    }

    public static boolean isBookAvailable(String book) {
        return books.contains(book);
    }

    public static String getUserByName(String username) {
        return users.containsKey(username) ? username : "Нет такого";
    }

    public static void initializeLibrary() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            addBook(String.format("Книга %d", i + 1));
        }

        for (int i = 0; i < 3; i++) {
            ArrayList<String> bookList = new ArrayList<>();

            int count = random.nextInt(50) + 1;
            while (count-- > 0) {
                String bookName = books.get(random.nextInt(books.size()));
                if (!bookList.contains(bookName)) {
                    bookList.add(bookName);
                }
            }

            // TODO: обновить под использование метода
            users.put(String.format("Имя %d", i + 1), bookList);
        }
    }

}
