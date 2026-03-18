import java.util.Scanner;

public class Ex11CheckInput {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Выводим приглашение для ввода
        System.out.print("Введите целое число: ");

        // Инициализируем переменную для хранения введенного числа
        int number = 0;

        // Проверяем, является ли следующий ввод целым числом
        if (scanner.hasNextInt()) {
            // Если да, считываем это число
            number = scanner.nextInt();
            // Выводим считанное число для подтверждения
            System.out.println(number);
        } else {
            // Если ввод не является целым числом, выводим сообщение об ошибке
            System.out.println("Ошибка");
            // Закрываем Scanner для освобождения ресурсов
            scanner.close();
            // Завершаем выполнение программы
            return;
        }

        // Если ввод был корректным, умножаем число на 10 и выводим результат
        System.out.println(number * 10);

        // Выводим сообщение о завершении программы
        System.out.println("Окончание программы");

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }
}
