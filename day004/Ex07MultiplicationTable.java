import java.util.Scanner;

public class Ex07MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        if (n >= 11 || n <= 0) {
            System.out.println("Ошибка ввода n");
            scanner.close();
            return;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", n, i, n * i);
        }

        scanner.close();
    }
}
