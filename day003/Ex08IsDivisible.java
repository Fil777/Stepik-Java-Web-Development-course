// Напишите программу, которая принимает два целых числа и проверяет,
// делится ли первое число на второе без остатка.

import java.util.Scanner;

public class Ex08IsDivisible {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод первого числа
        System.out.print("Введите первое число: ");
        int x = scanner.nextInt();

        // Запрашиваем у пользователя ввод второго числа
        System.out.print("Введите второе число: ");
        int y = scanner.nextInt();

        // Проверяем, не равен ли делитель нулю
        if (y != 0) {
            // Проверяем, делится ли x на y без остатка
            if (x % y == 0) {
                System.out.println(x + " делится на " + y + " без остатка");
            } else {
                System.out.println(x + " не делится на " + y + " без остатка");
            }
        } else {
            // Выводим сообщение об ошибке, если делитель равен нулю
            System.out.println("На ноль делить нельзя");
        }

        // Альтернативный способ проверки делимости с использованием логического И
        if (y != 0 && x % y == 0) {
            System.out.println(x + " делится на " + y + " без остатка");
        } else {
            System.out.println(x + " не делится на " + y + " без остатка");
        }

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }
}
