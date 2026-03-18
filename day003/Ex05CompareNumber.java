// Напишите программу, которая принимает два целых числа и выводит на консоль,
// какое из них больше.

import java.util.Scanner;

public class Ex05CompareNumber {
    public static void main(String[] args) {
        // Создаем объект Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод первого числа
        System.out.print("Введите первое число: ");
        int x = scanner.nextInt();

        // Запрашиваем у пользователя ввод второго числа
        System.out.print("Введите второе число: ");
        int y = scanner.nextInt();

        // Первый способ сравнения чисел с использованием вложенных условий
        if (x == y) {
            System.out.println("Числа равны");
        } else {
            if (x > y) {
                System.out.println(">> " + x + " больше " + y);
            } else {
                System.out.println(y + " больше " + x);
            }
        }

        // Второй способ сравнения чисел с использованием else if
        if (x > y) {
            System.out.println(">> " + x + " больше " + y);
        } else if (y > x) {
            System.out.println(y + " больше " + x);
        } else {
            System.out.println("Числа равны");
        }

        // Третий способ сравнения чисел, начиная с проверки равенства
        if (y == x) {
            System.out.println("Числа равны");
        } else if (y > x) {
            System.out.println(y + " больше " + x);
        } else {
            System.out.println(">> " + x + " больше " + y);
        }

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }
}
