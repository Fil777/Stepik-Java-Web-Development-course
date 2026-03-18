import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш вес в килограммах: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите ваш рост в метрах: ");
        double height = Double.parseDouble(scanner.nextLine());
        double bmi = weight / (height * height);
        System.out.printf("Ваш индекс массы тела (ИМТ): %.2f\n", bmi);
        System.out.print("Меньше 18.5 - Недостаточный вес\n"
            + "18.5 - 24.9 - Нормальный вес\n"
            + "25 - 29.9 - Избыточный вес\n" 
            + "30 и более - Ожирение\n"       
        );
    }
}