import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите радиус основания цилиндра: ");
        double radius = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите высоту цилиндра: ");
        double height = Double.parseDouble(scanner.nextLine());

        double square = 2.0 * Math.PI * radius * (radius + height);
        System.out.printf("Площадь поверхности цилиндра: %.2f\n", square);

        double volume = Math.PI * radius * radius * height;
        System.out.printf("Объем цилиндра: %.2f\n", volume);

    }
}