import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int value = scanner.nextInt();
        scanner.close();

        boolean isPrime = true;
        if (value <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        String result = isPrime ? "" : " не";

        System.out.printf("Число %d%s является простым", value, result);
    }
}
