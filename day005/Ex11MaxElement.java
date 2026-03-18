import java.util.Arrays;
import java.util.Random;

public class Ex11MaxElement {
    public static void main(String[] args) {
        Random random = new Random();
        // 1. Создать массив из n вещественных чисел
        int count = random.nextInt(5, 15);
        double[] values = new double[count];

        // 2. Заполнить массив случайными числами от 0 до 1 (2 знака после запятой)
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.floor(random.nextDouble() * 100) / 100.0;
        }

        // 3. Найти максимальный элемент
        // [0.89, 0.64, 0.29, 0.79, 0.95]
        if (values.length == 0) {
            System.out.println("Массив пустой");
            return;
        }

        int positionMax = 0;
        double max = values[positionMax];

        for (int index = 1; index < values.length; index++) {
            if (values[index] > max) {
                max = values[index];
                positionMax = index;
            }
        }

        // 4. Распечатать результат
        System.out.println(Arrays.toString(values));
        System.out.printf("Максимальный элемент: %.2f\n", max);
        System.out.printf("Индекс максимального элемента: %d\n", positionMax);

    }
}
