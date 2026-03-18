import java.util.Arrays;
import java.util.Random;

public class Ex14EvenCount {
    public static void main(String[] args) {
        Random random = new Random();

        // 1. Создать массив из n целых чисел
        int count = random.nextInt(5, 10);
        int[] numbers = new int[count];

        // 2. Заполнить массив случайными числами от -50 до 50
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-50, 51);
        }

        // 3. Подсчитать количество четных чисел в массиве
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            }
        }

        // numbers - 1 2 3 4 5 6
        // evenNumbers 0 0 0
        // 4. Собрать массив четных чисел
        int[] evenNumbers = new int[evenCount];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[index] = numbers[i];
                index++;
            }
        }

        // 5. Распечатать, всё что просят
        System.out.printf("Введите n: %d\n", count);
        System.out.printf("Исходный массив: %s\n", Arrays.toString(numbers));
        System.out.printf("Количество четных чисел: %d\n", evenCount);
        System.out.printf("Четные числа: %s\n", Arrays.toString(evenNumbers));
    }
}
