import java.util.Scanner;

public class BillSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte errcode = 0;

        double billAmount = 0.0;
        System.out.print("Введите сумму счёта: ");
        if (scanner.hasNextDouble()) {
            billAmount = Double.parseDouble(scanner.nextLine());
            if (billAmount <= 0.0) {
                errcode = -1;
            }
        } else {
            errcode = -1;
        }

        double tipPercentage = 0.0;
        if (errcode == 0) {
            System.out.print("Введите процент чаевых: ");
            if (scanner.hasNextDouble()) {
                tipPercentage = Double.parseDouble(scanner.nextLine());
                if (tipPercentage < 0.0) {
                    errcode = -2;
                }
            } else {
                errcode = -2;
            }
        }

        int numberOfPeople = 0;
        if (errcode == 0) {
            System.out.print("Введите количество участников: ");
            if (scanner.hasNextInt()) {
                numberOfPeople = Integer.parseInt(scanner.nextLine());
                if (numberOfPeople <= 0) {
                    errcode = -3;
                }
            } else {
                errcode = -3;
            }
        }

        scanner.close();

        if (errcode == -1) {
            System.out.println("Ошибка: значение должно быть положительным числом");
            return;
        } else if (errcode == -2) {
            System.out.println("Ошибка: значение должно быть неотрицательным числом");
            return;
        } else if (errcode == -3) {
            System.out.println("Ошибка: значение должно быть положительным целым числом");
            return;
        }

        double tipAmount = billAmount * (tipPercentage / 100); // Сумма, добавляемая к счёту в виде чаевых.
        double totalAmount = billAmount + tipAmount; // Итоговая сумма, которую необходимо оплатить.
        double perPersonAmount = totalAmount / numberOfPeople; // Сумма, которую должен заплатить каждый участник.

        System.out.printf("\nСумма счета: %.2f\n", billAmount);
        System.out.printf("Процент чаевых: %.2f%%\n", tipPercentage);
        System.out.printf("Сколько человек участвовало в обеде: %d\n", numberOfPeople);
        System.out.printf("Общий счёт: %.2f\n", totalAmount);
        System.out.printf("Сумма чаевых: %.2f\n", tipAmount);
        System.out.printf("С каждого: %.2f\n", perPersonAmount);

        System.out.println("\nУспешное окончание программы\n");
    }
}
