public class Ex06BillSplitter {
    public static void main(String[] args) {
        // Ввод суммы счёта
        double billAmount = 1000;
        System.out.printf("Сумма счёта: %.2f\n", billAmount);

        // Ввод процента чаевых
        double tipPercentage = 10;
        System.out.printf("Процент чаевых: %.2f\n", tipPercentage);

        // Ввод количества человек
        int numberOfPeople = 4;
        System.out.printf("Сколько человек участвовало в обеде: %d\n", numberOfPeople);

        // Расчёт суммы чаевых
        double tipAmount = billAmount * tipPercentage / 100;
        // Общая сумма
        double totalAmount = billAmount + tipAmount;
        System.out.printf("Общий счёт: %.2f\n", totalAmount);

        // Сумма на одного человека
        double perPersonAmount = totalAmount / numberOfPeople;

        System.out.printf("Процент чаевых: %.1f%%\n", tipPercentage);
        System.out.println("Процент чаевых: " + tipPercentage + "%");

        System.out.printf("С каждого: %.2f", perPersonAmount);
    }
}
