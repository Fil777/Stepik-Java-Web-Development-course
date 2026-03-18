import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое значение: ");
        int value = scanner.nextInt();
        scanner.close();
        int factorial = 1;
        for (int i = 1; i <= value; i++) {
            factorial *= i;
        }
        System.out.println("Факториал " + value + " = " + factorial);
    }
}
