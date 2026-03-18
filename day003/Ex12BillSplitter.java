import java.util.Scanner;

public class Ex12BillSplitter {
    public static void main(String[] args) {
        // 1.1 Сумма счёта должна быть числом
        // 1.2 Сумма счёта должна быть положительным числом.
        // 2.1 Процент чаевых должен быть числом.
        // 2.2 Процент чаевых должен быть неотрицательным числом.
        // 3.1 Количество участников должно быть числом.
        // 3.2 Количество участников должно быть положительным числом.

        Scanner scanner = new Scanner(System.in);

        // Ввод суммы счёта
        System.out.print("Введите сумму счёта: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: Сумма счёта должна быть числом");
            scanner.close();
            return;
        }
        double billAmount = scanner.nextDouble();
        if (billAmount <= 0) {
            System.out.println("Ошибка: Сумма счёта должна быть положительным числом");
            scanner.close();
            return;
        }

        // Ввод процента чаевых
        System.out.print("Введите процент чаевых: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: Процент чаевых должен быть числом");
            scanner.close();
            return;
        }
        double tipPercentage = scanner.nextDouble();
        if (tipPercentage < 0) {
            System.out.println("Ошибка: Процент чаевых должен быть неотрицательным числом");
            scanner.close();
            return;
        }

        // Ввод количества человек
        System.out.printf("Введите количество участников: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Количество участников должно быть числом.");
            scanner.close();
            return;
        }
        int numberOfPeople = scanner.nextInt();
        if (numberOfPeople <= 0) {
            System.out.println("Ошибка: Количество участников должно быть положительным числом.");
            scanner.close();
            return;
        }

        // Расчёт суммы чаевых
        double tipAmount = billAmount * tipPercentage / 100;
        // Общая сумма
        double totalAmount = billAmount + tipAmount;

        // Сумма на одного человека
        double perPersonAmount = totalAmount / numberOfPeople;

        System.out.printf("\nСумма счёта: %.2f\n", billAmount);
        System.out.printf("Сколько человек участвовало в обеде: %d\n", numberOfPeople);
        System.out.printf("Общий счёт: %.2f\n", totalAmount);
        System.out.printf("Процент чаевых: %.1f%%\n", tipPercentage);
        System.out.printf("С каждого: %.2f\n", perPersonAmount);

        scanner.close();
    }
}
