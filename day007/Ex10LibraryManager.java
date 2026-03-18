import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Ex10LibraryManager {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        HashMap<String, ArrayList<String>> users = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            books.add(String.format("Книга %d", i + 1));
        }

        for (int i = 0; i < 3; i++) {
            ArrayList<String> bookList = new ArrayList<>();

            int count = random.nextInt(3) + 1;
            while (count-- > 0) {
                bookList.add(books.get(random.nextInt(books.size())));
            }

            users.put(String.format("Имя %d", i + 1), bookList);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Поиск книги");
            System.out.println("4. Добавить пользователя");
            System.out.println("5. Взять книгу");
            System.out.println("6. Показать книги пользователя");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите название и автора книги: ");
                String bookName = scanner.nextLine();
                books.add(bookName);
            } else if (choice == 2) {
                System.out.print("Введите название книги для удаления: ");
                String bookName = scanner.nextLine();
                books.remove(bookName);
            } else if (choice == 3) {
                System.out.println("Введите название книги для поиска: ");
                String searchBook = scanner.nextLine();

                for (String book : books) {
                    if (book.contains(searchBook)) {
                        System.out.println("Найдена книга: " + book);
                    }
                }
            } else if (choice == 4) {
                System.out.println("Введите имя пользователя: ");
                String username = scanner.nextLine();
                users.put(username, new ArrayList<>());
            } else if (choice == 5) {
                System.out.println("Введите имя пользователя: ");
                String username = scanner.nextLine();

                System.out.println("Введите название книги для взятия: ");
                String bookTitle = scanner.nextLine();

                if (books.contains(bookTitle)) {
                    users.get(username).add(bookTitle);
                } else {
                    System.out.println("Такой книги нет");
                }
            } else if (choice == 6) {
                System.out.println("Введите имя пользователя: ");
                String username = scanner.nextLine();
                ArrayList<String> userBooks = users.get(username);
                if (userBooks == null) {
                    System.out.println("Список пуст");
                } else {
                    System.out.println(userBooks);
                }
            } else {
                scanner.close();
                return;
            }

        }

    }
}
