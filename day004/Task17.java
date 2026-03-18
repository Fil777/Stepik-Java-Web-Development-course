import java.util.Random;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomInt = random.nextInt(1, 100);
        int inNumber = 0;
        int counter = 0;

        while (true) {
            System.out.println("Введите целое значение от 1 до 100: ");
            inNumber = scanner.nextInt();
            counter++;
            if (inNumber < randomInt) {
                System.out.println("Загаданное число больше");
            } else if (inNumber > randomInt) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Вы угадали!");
                System.out.println("Количество попыток: " + counter);
                break;
            }
        }

        scanner.close();

    }
}
