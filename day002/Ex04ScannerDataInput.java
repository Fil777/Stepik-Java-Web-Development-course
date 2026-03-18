import java.util.Scanner;

public class Ex04ScannerDataInput {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения данных из консоли
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод имени
        System.out.print("Введите ваше имя: ");
        // Читаем строку, введенную пользователем, и сохраняем ее в переменную firstName
        String firstName = scanner.nextLine();

        // Запрашиваем у пользователя ввод фамилии
        System.out.print("Введите вашу фамилию: ");
        // Читаем строку, введенную пользователем, и сохраняем ее в переменную lastName
        String lastName = scanner.nextLine();

        // Запрашиваем у пользователя ввод возраста
        System.out.print("Введите ваш возраст: ");
        // Читаем целое число, введенное пользователем, и сохраняем его в переменную age
        int age = scanner.nextInt();

        // Выводим приветствие с использованием введенных данных
        // %s - место для подстановки строковых значений
        // %d - место для подстановки целочисленных значений
        // Значения подставляются в порядке следования после строки форматирования
        System.out.printf("Привет, %s %s! Ваш возраст: %d.\n", firstName, lastName, age);

        // Закрываем Scanner, чтобы освободить ресурсы
        scanner.close();
    }
}
