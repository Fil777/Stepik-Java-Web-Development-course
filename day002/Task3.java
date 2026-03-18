import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату x1: ");
        double x1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите координату y1: ");
        double y1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите координату x2: ");
        double x2 = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите координату y2: ");
        double y2 = Double.parseDouble(scanner.nextLine());

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Расстояние между (%.2f, %.2f) и (%.2f, %.2f) = %.2f\n", x1, y1, x2, y2, distance);

    }
}