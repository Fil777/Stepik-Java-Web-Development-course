package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("BOOKS:\n");
            for (String book : books) {
                bw.write(book + "\n");
            }

            bw.write("\nUSERS:\n");

            for (String user : users.keySet()) {
                bw.write(user + ":");
                ArrayList<String> userBooks = users.get(user);
                bw.write(String.join(";", userBooks) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean readingBooks = true;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("BOOKS:")) {
                    readingBooks = true;
                } else if (line.equals("USERS:")) {
                    readingBooks = false;
                } else if (readingBooks) {
                    if (!line.isEmpty()) {
                        addBook(line);
                    }
                } else {
                    if (!line.isEmpty()) {
                        String[] parts = line.split(":");
                        String username = parts[0];
                        String[] userBooks = parts[1].split(";");
                        addUser(username);
                        for (String book : userBooks) {
                            borrowBook(username, book);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
