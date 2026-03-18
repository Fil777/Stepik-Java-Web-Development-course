import java.util.Scanner;

public class Ex07BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш вес в килограммах: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите ваш рост в метрах: ");
        double height = Double.parseDouble(scanner.nextLine());

        double bmi = weight / (Math.pow(height, 2));

        System.out.printf("Ваш индекс массы тела (ИМТ): %.2f \n", bmi);
        System.out.println("Меньше 18.5 - Недостаточный вес");
        System.out.println("18.5 - 24.9 - Нормальный вес");
        System.out.println("25 - 29.9 - Избыточный вес");
        System.out.println("30 и более - Ожирение");
        scanner.close();
    }
}
