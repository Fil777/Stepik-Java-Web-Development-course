import java.util.Random;

public class Ex02SumAllElements {
    public static void main(String[] args) {
        // Создаем двумерный массив размером 3x3
        int[][] matrix = new int[3][3];

        // Создаем объект класса Random для генерации случайных чисел
        Random random = new Random();
        // Инициализируем переменную sum для хранения суммы элементов массива
        int sum = 0;

        // Проходим по всем элементам массива
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                // Заполняем массив случайными числами от 0 до 9
                matrix[column][row] = random.nextInt(10);
                // Добавляем значение текущего элемента к сумме
                sum += matrix[column][row];
            }
        }

        // Выводим массив на экран
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                // Выводим элемент массива, используя форматированный вывод
                System.out.printf("%3d", matrix[row][column]);
            }
            // Переходим на новую строку после вывода каждой строки массива
            System.out.println();
        }

        // Выводим сумму всех элементов массива
        System.out.println("Сумма: " + sum);
    }
}
