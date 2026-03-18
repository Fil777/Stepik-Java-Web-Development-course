import java.util.Random;

public class Ex09SimpleArray {
    public static void main(String[] args) {
        Random random = new Random();

        // 1. Ввести число n
        int n = random.nextInt(5, 15);
        System.out.println("Введите n: " + n);

        // 2. Создать массив из n элементов
        int[] numbers = new int[n];

        // 3. Заполните массив случайными числами от 1 до 100
        for (int index = 0; index < n; index++) {
            numbers[index] = random.nextInt(100) + 1;
        }

        // 4. Распечатать "красиво"
        for (int index = 0; index < numbers.length; index++) {
            System.out.printf("array[%d] = %d\n", index, numbers[index]);
        }
    }
}
