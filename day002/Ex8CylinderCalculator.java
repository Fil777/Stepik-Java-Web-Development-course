import java.util.Scanner;

public class Ex8CylinderCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус основания цилиндра: ");
        double radius = scanner.nextDouble();

        System.out.print("Введите высоту цилиндра: ");
        double height = scanner.nextDouble();

        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.printf("Площадь поверхности цилиндра: %.2f \n", surfaceArea);
        System.out.printf("Объем цилиндра: %.2f \n", volume);
        scanner.close();
    }
}
