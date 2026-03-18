import java.util.Scanner;

public class Ex05SquaresOfNumbers {
    public static void main(String[] args) {
        int step = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите  значение n: ");
        int n = scanner.nextInt();

        while (step <= n) {
            System.out.printf("%d ", step * step);
            step++;
        }

        System.out.println();

        scanner.close();
    }
}
