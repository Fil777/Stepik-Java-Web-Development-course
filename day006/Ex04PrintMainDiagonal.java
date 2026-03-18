import java.util.Random;

public class Ex04PrintMainDiagonal {
    public static void main(String[] args) {
        // Создаем двумерный массив 4x4
        int[][] matrix = new int[4][4];

        // Создаем объект класса Random для генерации случайных чисел
        Random random = new Random();

        // Заполняем матрицу случайными числами от 0 до 99
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = random.nextInt(100);
            }
        }

        // Выводим всю матрицу на экран
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%3d", matrix[row][column]);
            }
            System.out.println();
        }

        System.out.println();

        // Выводим матрицу, заменяя все элементы, кроме главной диагонали, на "*"
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (row == column) {
                    System.out.printf("%3d", matrix[row][column]);
                } else {
                    System.out.print("  *");
                }
            }
            System.out.println();
        }

        // Выводим только элементы главной диагонали
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%d ", matrix[i][i]);
        }

        System.out.println();
    }
}
