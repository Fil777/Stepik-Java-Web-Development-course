public class BillSplitter {
    public static void main(String[] args) {

        double billAmount = 2000; // Общая сумма, которую нужно оплатить за обед.
        double tipPercentage = 10; // Процент от суммы счёта, который будет добавлен в качестве чаевых.
        int numberOfPeople = 4; // Количество людей, участвующих в оплате счёта.

        double tipAmount = billAmount * (tipPercentage / 100); // Сумма, добавляемая к счёту в виде чаевых.
        double totalAmount = billAmount + tipAmount; // Итоговая сумма, которую необходимо оплатить.
        double perPersonAmount = totalAmount / numberOfPeople; // Сумма, которую должен заплатить каждый участник.

        System.out.printf("Сумма счета: %.2f\n", billAmount);
        System.out.printf("Процент чаевых: %.2f%%\n", tipPercentage);
        System.out.printf("Сколько человек участвовало в обеде: %d\n", numberOfPeople);
        System.out.printf("Общий счёт: %.2f\n", totalAmount);
        System.out.printf("Сумма чаевых: %.2f\n", tipAmount);
        System.out.printf("С каждого: %.2f\n", perPersonAmount);

    }
}
