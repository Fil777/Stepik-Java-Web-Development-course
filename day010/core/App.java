package core;

import java.util.Scanner;

public class App {
    public static void run() {
        BookManager.loadFromFile("library.db");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Terminal.writeLine("1. Добавить книгу");
            Terminal.writeLine("2. Удалить книгу");
            Terminal.writeLine("3. Поиск книги");
            Terminal.writeLine("4. Показать все книги");
            Terminal.writeLine("5. Добавить пользователя");
            Terminal.writeLine("6. Удалить пользователя");
            Terminal.writeLine("7. Показать всех пользователей");
            Terminal.writeLine("8. Показать книги пользователя");
            Terminal.writeLine("9. Взять книгу");
            Terminal.writeLine("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Terminal.write("Введите название и автора книги: ");
                String bookName = scanner.nextLine();
                BookManager.addBook(bookName);
            } else if (choice == 2) {
                Terminal.write("Введите название книги для удаления: ");
                String bookName = scanner.nextLine();
                BookManager.removeBook(bookName);
            } else if (choice == 3) {
                Terminal.write("Введите название книги для поиска: ");
                String bookName = scanner.nextLine();
                BookManager.searchBook(bookName);
            } else if (choice == 4) {
                BookManager.displayAllBooks();
            } else if (choice == 5) {
                Terminal.write("Введите имя пользователя: ");
                String username = scanner.nextLine();
                BookManager.addUser(username);
            } else if (choice == 6) {
                Terminal.write("Введите имя пользователя, которого нужно удалить: ");
                String username = scanner.nextLine();
                BookManager.removeUser(username);
            } else if (choice == 7) {
                BookManager.displayAllUsers();
            } else if (choice == 8) {
                Terminal.write("Введите имя пользователя, для просмотра книг: ");
                String username = scanner.nextLine();
                BookManager.displayUserBooks(username);
            } else if (choice == 9) {
                Terminal.write("Введите имя пользователя:");
                String username = scanner.nextLine();

                Terminal.write("Введите название книги:");
                String bookName = scanner.nextLine();

                BookManager.borrowBook(username, bookName);
            } else {
                scanner.close();
                BookManager.saveToFile("library.db");
                return;
            }
        }
    }
}
