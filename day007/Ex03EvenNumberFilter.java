import java.util.ArrayList;
import java.util.Random;

public class Ex03EvenNumberFilter {
    public static void main(String[] args) {
        // Создаем два списка: numbers для хранения всех чисел и evenNumbers для
        // хранения четных чисел
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        // Задаем количество чисел, которые нужно сгенерировать
        int count = 20;

        // Цикл для генерации случайных чисел и добавления их в список numbers
        for (int i = 0; i < count; i++) {
            // Генерируем случайное число от 1 до 100 и добавляем его в список numbers
            numbers.add(random.nextInt(100) + 1);

            // Получаем текущее число из списка numbers
            int current = numbers.get(i);

            // Проверяем, является ли текущее число четным
            if (current % 2 == 0) {
                // Если число четное, добавляем его в список evenNumbers
                evenNumbers.add(current);
            }
        }

        // Выводим исходную коллекцию чисел
        System.out.println("Исходная коллекция: " + numbers);

        // Выводим список четных чисел
        System.out.println("Список четных чисел: " + evenNumbers);
    }
}
