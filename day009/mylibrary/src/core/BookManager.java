package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BookManager {
    public static ArrayList<String> books = new ArrayList<>();
    public static HashMap<String, ArrayList<String>> users = new HashMap<>();
    public static String endOfList = "---";
    public static String fileName = "data.txt";

    static String addBook(String book) {
        if (book.isEmpty()) {
            return "Книга не указана";
        }
        books.add(book);
        return "Книга '" + book + "' добавлена";
    }

    public static String removeBook(String book) {
        if (book.isEmpty()) {
            return "Книга не указана";
        }
        if (!isRegisteredBook(book)){
            return "Книга '" + book +"' не зарегистрирована";
        }
        String ret = "Книга '" + book + "' удалена";
        if (isBookAvailable(book)) {
            books.remove(book);
            if (books.size() == 0) {
                return ret + "Книги на полке отсутствуют";
            }
            return ret;
        } else {
            return "Книга '" + book + "' отсутствует в библиотеке или находится на руках";
        }

    }

    public static String searchBook(String book) {
        if (book.trim().length() == 0) {
            return "Отсутствует поисковая строка";
        }
        boolean bookFound = false;
        for (String bookTitle : books) {
            if (bookTitle.toLowerCase().contains(book.toLowerCase())) {
                if (!bookFound) {
                    Terminal.writeLine("Найдены книги:");
                    bookFound = true;
                }
                Terminal.writeLine("'" + bookTitle + "' (на полке)");
            }
        }
        for (ArrayList<String> values : users.values()) {
            for (String bookTitle : values) {
                if (bookTitle.toLowerCase().contains(book.toLowerCase())) {
                    if (!bookFound) {
                        Terminal.writeLine("Найдены книги:");
                        bookFound = true;
                    }
                    Terminal.writeLine("'" + bookTitle + "' (у пользователя)");
                }
            }
        }
        return endOfList;
    }

    public static boolean isRegisteredBook(String book) {
        if (books.contains(book)) {
            return true;
        }
        for (ArrayList<String> arr : users.values()) {
            if (arr.contains(book)){
                return true;
            }
        }
        return false;
    }

    public static String displayAllBooks() {
        Terminal.writeNewLine("Все книги библиотеки:");
        for (String book : books) {
            Terminal.writeLine("'" + book + "' (на полке)");
        }
        for (ArrayList<String> values : users.values()) {
            for (String book : values) {
                Terminal.writeLine("'" + book + "' (у пользователя)");
            }
        }
        return endOfList;
    }

    public static String addUser(String name) {
        if (name.isEmpty()) {
            return "Пользователь не указан";
        }
        String user = getUserByName(name);
        if (user.isEmpty()) {
            users.put(name, new ArrayList<>());
            return "Пользователь '" + name + "' добавлен";
        } else {
            return "Пользователь '" + name + "' уже зарегистрирован как " + user;
        }
    }

    public static String removeUser(String name) {
        if (name.isEmpty()) {
            return "Пользователь не указан";
        }
        if (!isUserExists(name)){
            return "Пользователь '" + name +"' не зарегистрирован";
        }
        users.remove(name);
        return "Пользователь '" + name + "' удалён";
    }

    public static String getUserByName(String name) {
        for (String user : users.keySet()) {
            if (user.toLowerCase().contains(name.toLowerCase())) {
                return user;
            }
        }
        return "";
    }

    public static String displayUserBooks(String name) {
        if (name.isEmpty()) {
            return "Пользователь не указан";
        }
        if (!isUserExists(name)){
            return "Пользователь '" + name +"' не зарегистрирован";
        }
        Terminal.writeLine("Книги пользователя '" + name + "':");
        for (String book : users.get(name)) {
            Terminal.writeLine(book);
        }
        return endOfList;
    }

    public static String displayAllUsers() {
        Terminal.writeNewLine("Все пользователи библиотеки:");
        for (String user : users.keySet()) {
            Terminal.writeLine(user);
        }
        return endOfList;
    }

    public static boolean isUserExists(String name) {
        return users.containsKey(name);
    }

    public static boolean isUserHasBook(String name, String book) {
        if (isUserExists(name)) {
            return users.get(name).contains(book);
        }
        return false;
    }

    public static String borrowBook(String name, String book) {
        if (name.isEmpty()) {
            return "Пользователь не указан";
        }
        if (book.isEmpty()) {
            return "Книга не указана";
        }
        if (!isRegisteredBook(book)){
            return "Книга '" + book +"' не зарегистрирована";
        }
        if (!isUserExists(name)){
            return "Пользователь '" + name +"' не зарегистрирован";
        }
        users.get(name).add(book);
        removeBook(book);
        return "Книга '" + book + "' теперь у пользователя " + name;
    }

    public static String returnBook(String name, String book) {
        if (name.isEmpty()) {
            return "Пользователь не указан";
        }
        if (!isUserExists(name)){
            return "Пользователь '" + name +"' не зарегистрирован";
        }
        if (book.isEmpty()) {
            return "Книга не указана";
        }
        if (!isRegisteredBook(book)){
            return "Книга '" + book +"' не зарегистрирована";
        }
        if (!isUserHasBook(name,book)) {
            return "Книги '" + book + "' нет у пользователя '" + name + "'";
        }
        users.get(name).remove(book);
        books.add(book);
        return "Книга '" + book + "' теперь возвращена в библиотеку";
    }

    public static boolean isBookAvailable(String book) {
        return books.contains(book);
    }

    public static String saveToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("BOOKS:\n");
            for (String book : books) {
                writer.write(book + "\n");
            }
            writer.write("\nUSERS:");
            String comma;
            for (Map.Entry<String, ArrayList<String>> entry : users.entrySet()) {
                writer.write("\n" + entry.getKey() + ":");
                comma = "";
                for (String book : entry.getValue()) {
                    writer.write(comma + book);
                    if (comma.isEmpty()){
                        comma = ",";
                    }
                }
            }
            writer.write("\n");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
        return "Библиотека записана на диск";
    }

    public static String loadFromFile() {
        // очистка библиотеки и пользователей
        books.clear();
        users.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean booksSection = false;
            boolean usersSection = false;
            // читаем до строки BOOKS
            while (!booksSection) {
                line = reader.readLine();
                if (line == null) {
                    return "Формат файла нарушен или файл пуст";
                } else if (line.trim().isEmpty()) {
                    return "Формат файла нарушен";
                } else if (line.trim().equals("BOOKS:")) {
                    booksSection = true;
                }
            }
            // читаем книги в список
            while (booksSection) {
                line = reader.readLine();
                if (line == null) {
                    return "Формат файла нарушен (BOOKS)";
                } else if (line.trim().isEmpty()) {
                    booksSection = false;
                } else {
                    books.add(line);
                }
            }
            // читаем до строки USERS
            while (!usersSection) {
                line = reader.readLine();
                if (line == null) {
                    return "Формат файла нарушен (USERS)";
                } else if (line.trim().equals("USERS:")) {
                    usersSection = true;
                }
            }
            // читаем пользователей в словарь
            while (usersSection) {
                line = reader.readLine();
                if (line == null) {
                    usersSection = false;
                } else if (line.trim().isEmpty()) {
                    usersSection = false;
                } else {
                    String[] parts = line.split(":");
                    users.put(parts[0].trim(), new ArrayList<String>(Arrays.asList(parts[1].split(","))));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return "Библиотека считана с диска";
    }

}
