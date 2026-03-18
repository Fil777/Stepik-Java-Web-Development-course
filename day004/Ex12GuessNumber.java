import java.util.Random;
import java.util.Scanner;

public class Ex12GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);

        int guess, attempts = 0;

        while (true) {
            System.out.print("Введите ваше предположение: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Загаданное число больше");
            } else if (guess > secretNumber) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.printf("Поздравляю! Потребовалось шагов: %d\n", attempts);
                scanner.close();
                return;
            }
        }
    }
}
