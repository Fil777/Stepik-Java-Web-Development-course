import java.util.Scanner;

public class Ex09BillSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод суммы счёта
        System.out.print("Введите сумму счёта: ");
        double billAmount = scanner.nextDouble();

        // Ввод процента чаевых
        System.out.print("Введите процент чаевых: ");
        double tipPercentage = scanner.nextDouble();

        // Ввод количества человек
        System.out.printf("Введите количество участников: ");
        int numberOfPeople = scanner.nextInt();

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
