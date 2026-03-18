import java.util.Arrays;

public class Ex08Arrays {
    public static void main(String[] args) {
        // Объявление массива целых чисел
        int[] numbers;

        // Инициализация переменной для размера массива
        int count = 10;
        // Создание массива большого размера (может вызвать OutOfMemoryError)
        numbers = new int[count];

        // Альтернативный способ объявления и инициализации массива
        // int[] numbers = new int[count];

        // Индексы:   0 1 2 3 4 5 6 7 8 9
        // Значения: 10 0 0 0 0 0 0 0 0 0
        // Присваивание значения первому элементу массива
        numbers[0] = 10;

        // Присваивание значения четвертому элементу массива
        numbers[3] = 123;
        // Попытка обратиться к несуществующему индексу вызовет
        // ArrayIndexOutOfBoundsException
        // numbers[1111] = 123;

        // Получение значения из массива
        int temp = numbers[22];
        // Вывод значения элемента массива (по умолчанию 0)
        System.out.println(numbers[2]);
        System.out.println(temp);
        // Вывод всего массива в виде строки
        System.out.println(Arrays.toString(numbers));

        // Создание массива строк
        String[] str = new String[10];
        System.out.println(Arrays.toString(str));

        // Создание массива символов
        char[] chs = new char[11];
        System.out.println(Arrays.toString(chs));

        // Создание массива чисел с плавающей точкой
        double[] values = new double[20];
        System.out.println(Arrays.toString(values));

    }
}
