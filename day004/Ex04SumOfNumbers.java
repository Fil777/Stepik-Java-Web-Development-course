import java.util.Scanner;

public class Ex04SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        System.out.printf("Сумма чисел от 1 до %d равна %d\n", n, sum);

        System.out.printf("Сумма чисел от 1 до %d равна %d\n", n, n * (n + 1) / 2);
        scanner.close();
    }
}
