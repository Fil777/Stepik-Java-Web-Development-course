import java.util.Arrays;
import java.util.Scanner;

public class Ex10ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 0. Ввести n
        System.out.print("Количество элементов: ");
        int n = scanner.nextInt();

        // 1. Создайте массив из n целых чисел.
        int[] values = new int[n];

        // 2. Заполните массив значениями, введенными с клавиатуры
        for (int index = 0; index < values.length; index++) {
            System.out.printf("Введите values[%d]: ", index);
            values[index] = scanner.nextInt();
        }

        // 3. Посчитайте сумму всех элементов массива
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        // 4. Вывод всего на экран
        System.out.printf("Введенный массив: %s\n", Arrays.toString(values));
        System.out.printf("Сумма всех элементов: %d\n", sum);
        scanner.close();
    }
}
