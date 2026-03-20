package core;

import java.util.Scanner;
import core.Terminal;
import core.BookManager;

public class App {

    public static void run() {

        Scanner scanner = new Scanner(System.in);

        Terminal.writeLine("\nНачало работы\n");
        /*
         * //
         * while (true) {
         * Terminal.writeLine("1. Добавить книгу");
         * Terminal.writeLine("2. Удалить книгу");
         * Terminal.writeLine("3. Поиск книги");
         * Terminal.writeLine("4. Добавить пользователя");
         * Terminal.writeLine("5. Взять книгу");
         * Terminal.writeLine("6. Показать книги пользователя");
         * Terminal.writeLine("0. Выход");
         * 
         * int choice = scanner.nextInt();
         * scanner.nextLine();
         * 
         * switch (choice) {
         * case 0:
         * return;
         * break;
         * case 1:
         * BookManager.addBook(getStringByUserTerminal(
         * scanner, "Введите название и автора книги: "));
         * break;
         * case 2:
         * BookManager.removeBook(getStringByUserTerminal(
         * scanner, "Введите название книги для удаления: "));
         * break;
         * case 3:
         * String book = BookManager.searchBook(getStringByUserTerminal(
         * scanner, "Введите название книги для поиска: "));
         * if (book != null) {
         * Terminal.writeLine("Найдена книга: " + book);
         * }
         * break;
         * case 4:
         * String userNew = getStringByUserTerminal(
         * scanner, "Введите имя пользователя: ");
         * String user = BookManager.getUserByName(userNew);
         * if (user == null) {
         * BookManager.addUser(userNew);
         * } else {
         * Terminal.writeLine("Пользователь " + userNew
         * + " уже зарегистриррован как " + user);
         * }
         * break;
         * case 5:
         * String name = getStringByUserTerminal(
         * scanner, "Введите имя пользователя: ");
         * String userName = BookManager.getUserByName(name);
         * if (userName == null) {
         * Terminal.writeLine("Пользователь " + name + " не зарегестрирован");
         * break;
         * }
         * String book = getStringByUserTerminal(
         * scanner, "Введите название книги для взятия: ");
         * String bookTitle = BookManager.searchBook(book);
         * if (bookTitle == null) {
         * Terminal.writeLine("Книги " + book + " нет в библиотеке");
         * break;
         * }
         * if (!BookManager.isBookAvailable(bookTitle)) {
         * Terminal.writeLine("Книга " + bookTitle + " на руках");
         * break;
         * }
         * BookManager.borrowBook(userName, bookTitle);
         * break;
         * // case 6:
         * // String userName6 = getAndCheckUser(Scanner scanner)
         * // if (userName == null){
         * // break;
         * // }
         * // BookManager.displayUserBooks(userName6);
         * // break;
         * default:
         * break;
         * }
         * 
         * }
         */ //
    }

    public static String getStringByUserTerminal(Scanner scanner, String text) {
        System.out.print(text);
        String s = scanner.nextLine();
        return s;
    }

    public static String getAndCheckUser(Scanner scanner) {
        String name = getStringByUserTerminal(
                scanner, "Введите имя пользователя: ");
        String userName = BookManager.getUserByName(name);
        if (userName == null) {
            Terminal.writeLine("Пользователь " + name + " не зарегестрирован");
        }
        return userName;
    }
}
