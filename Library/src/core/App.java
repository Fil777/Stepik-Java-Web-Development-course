package core;

import java.util.Scanner;

import core.BookManager;
import core.Terminal;

public class App {

    public static void run() {

        Scanner scanner = new Scanner(System.in);

        Terminal.writeNewLine(BookManager.loadFromFile());

        Terminal.writeLine("\nНачало работы, здравствуйте!");
        while (true) {
            Terminal.writeNewLine("Выберите действие:");
            Terminal.writeLine("1. Добавить книгу");
            Terminal.writeLine("2. Удалить книгу");
            Terminal.writeLine("3. Поиск книги");
            Terminal.writeLine("4. Добавить пользователя");
            Terminal.writeLine("5. Взять книгу");
            Terminal.writeLine("6. Показать книги пользователя");
            Terminal.writeLine("7. Вернуть книгу");
            Terminal.writeLine("8. Показать все книги");
            Terminal.writeLine("9. Показать всех пользователей");
            Terminal.writeLine("S. Записать библиотеку в файл");
            Terminal.writeLine("L. Загрузить библиотеку из файла");
            Terminal.writeLine("0. Выход");
            Terminal.writeLine();
            Terminal.write(">");

            char choice = scanner.next().charAt(0);
            scanner.nextLine();
            if ("0123456789SL".indexOf(choice) < 0) {
                Terminal.writeLine("Некорректный ввод");
                continue;
            }

            switch (choice) {
                case '1': // Добавить книгу
                    Terminal.writeLine(BookManager.addBook(getStringByUserTerminal(
                            scanner, "Введите название и автора книги: ")));
                    break;
                case '2': // Удалить книгу
                    Terminal.writeLine(BookManager.removeBook(getStringByUserTerminal(
                            scanner, "Введите точное название книги для удаления: ")));
                    break;
                case '3': // Поиск книги
                    Terminal.writeLine(BookManager.searchBook(getStringByUserTerminal(
                            scanner, "Введите строку для поиска: ")));
                    break;
                case '4': // Добавить пользователя
                    String userNew = getStringByUserTerminal(
                            scanner, "Введите имя пользователя: ");
                    Terminal.writeLine(BookManager.addUser(userNew));
                    break;
                case '5': // Взять книгу
                    String user5 = getAndCheckUser(scanner);
                    if (user5.isEmpty()) {
                        break;
                    }
                    String book5 = getAndCheckBook(scanner);
                    if (!BookManager.isBookAvailable(book5)) {
                        Terminal.writeLine("Книга '" + book5 + "' на руках");
                        break;
                    }
                    Terminal.writeLine(BookManager.borrowBook(user5, book5));
                    break;
                case '6': // Показать книги пользователя
                    String userName6 = getAndCheckUser(scanner);
                    Terminal.writeLine(BookManager.displayUserBooks(userName6));
                    break;
                case '7': // Вернуть книгу
                    String userName7 = getAndCheckUser(scanner);
                    if (userName7.isEmpty()) {
                        break;
                    }
                    String book7 = getAndCheckBook(scanner);
                    Terminal.writeLine(BookManager.returnBook(userName7, book7));
                    break;
                case '8': // Показать все книги
                    Terminal.writeLine(BookManager.displayAllBooks());
                    break;
                case '9': // Показать всех пользователей
                    Terminal.writeLine(BookManager.displayAllUsers());
                    break;
                case 'S': // Записать библиотеку в файл
                    Terminal.writeLine(BookManager.saveToFile());
                    break;
                case 'L': // Загрузить библиотеку из файла
                    Terminal.writeLine(BookManager.loadFromFile());
                    break;
                case '0': // Выход
                    Terminal.writeNewLine("Спасбо за работу, до свидания!");
                    scanner.close();
                    Terminal.writeNewLine(BookManager.saveToFile());
                    return;
                // default:
                // break;
            }

        }
    }

    public static String getStringByUserTerminal(Scanner scanner, String text) {
        System.out.print(text);
        String s = "";
        while (s.isEmpty()) {
            s = scanner.nextLine().trim();
        }
        return s;
    }

    public static String getAndCheckUser(Scanner scanner) {
        String name = getStringByUserTerminal(
                scanner, "Введите имя пользователя: ");

        String foundName = BookManager.getUserByName(name);
        if (foundName.isEmpty()) {
            Terminal.writeLine("Пользователь '" + name + "' не зарегистрирован");
        }
        Terminal.writeLine("'" + foundName + "' зарегистрирован");
        return foundName;
    }

    public static String getAndCheckBook(Scanner scanner) {
        String book = getStringByUserTerminal(
                scanner, "Введите точное название книги для взятия: ");
        return book;
    }
}
