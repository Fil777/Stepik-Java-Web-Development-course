import java.util.Scanner;

public class Ex02MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = getN(scanner);
        close(scanner, n);
        getTable(n);

        n = getN(scanner);
        close(scanner, n);
        getTable(n);

        scanner.close();
    }

    private static int getN(Scanner scanner) {
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();
        return n;
    }

    private static void close(Scanner scanner, int n) {
        if (n >= 11 || n <= 0) {
            System.out.println("Ошибка ввода n");
            scanner.close();
            System.exit(0);
        }
    }

    private static void getTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d\n", n, i, n * i);
        }
    }
}
