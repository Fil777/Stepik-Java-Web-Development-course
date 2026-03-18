import java.util.Scanner;

public class BillSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму счёта: ");
        double billAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите процент чаевых: ");
        double tipPercentage = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите количество участников: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        double tipAmount = billAmount * (tipPercentage / 100); // Сумма, добавляемая к счёту в виде чаевых.
        double totalAmount = billAmount + tipAmount; // Итоговая сумма, которую необходимо оплатить.
        double perPersonAmount = totalAmount / numberOfPeople; // Сумма, которую должен заплатить каждый участник.

        System.out.printf("\nСумма счета: %.2f\n", billAmount);
        System.out.printf("Процент чаевых: %.2f%%\n", tipPercentage);
        System.out.printf("Сколько человек участвовало в обеде: %d\n", numberOfPeople);
        System.out.printf("Общий счёт: %.2f\n", totalAmount);
        System.out.printf("Сумма чаевых: %.2f\n", tipAmount);
        System.out.printf("С каждого: %.2f\n", perPersonAmount);
    }
}
