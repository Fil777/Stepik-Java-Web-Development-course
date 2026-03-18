import java.util.Random;

public class Ex03FindMaxElement {
    public static void main(String[] args) {
        // Создаем двумерный массив размером 4x4
        int[][] matrix = new int[4][4];

        // Создаем объект класса Random для генерации случайных чисел
        Random random = new Random();

        // Инициализируем переменные для хранения индексов максимального элемента
        int indexMaxRow = 0, indexMaxColumn = 0;
        // Инициализируем переменную для хранения максимального элемента
        int maxItem = matrix[indexMaxRow][indexMaxColumn];

        // Проходим по всем элементам массива
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                // Заполняем массив случайными числами от 0 до 99
                matrix[row][column] = random.nextInt(100);
                // Если текущий элемент больше максимального, обновляем максимальный элемент и
                // его индексы
                if (matrix[row][column] > maxItem) {
                    maxItem = matrix[row][column];
                    indexMaxRow = row;
                    indexMaxColumn = column;
                }
            }
        }

        // Выводим массив на экран
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                // Выводим элементы массива с форматированием (3 символа на каждый элемент)
                System.out.printf("%3d", matrix[row][column]);
            }
            // Переходим на новую строку после каждой строки массива
            System.out.println();
        }

        // Выводим максимальный элемент и его индексы
        System.out.printf("matrix[%d][%d] = %d\n",
                indexMaxRow, indexMaxColumn, maxItem);
    }
}
