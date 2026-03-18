import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex07shuffleList {
    public static void main(String[] args) {
        // Создаем объект класса Random для генерации случайных чисел
        Random random = new Random();

        // Генерируем случайное число от 5 до 14 включительно
        int count = random.nextInt(5, 15);

        // Создаем ArrayList для хранения целых чисел
        ArrayList<Integer> list = new ArrayList<>();

        // Заполняем список числами от 1 до count
        for (int i = 0; i < count; i++) {
            // Закомментированная строка: добавление случайного числа от 1 до 10
            // list.add(random.nextInt(10) + 1);

            // Добавляем в список числа от 1 до count
            list.add(i + 1);
        }

        // Выводим исходный список
        System.out.println(list);

        // Перемешиваем элементы списка с помощью метода shuffle класса Collections
        Collections.shuffle(list);

        // Закомментированный код: альтернативный способ перемешивания списка
        // for (int i = list.size() - 1; i > 0; i--) {
        // int j = random.nextInt(i + 1);
        // int temp = list.get(i);
        // list.set(i, list.get(j));
        // list.set(j, temp);
        // }

        // Выводим перемешанный список
        System.out.println(list);
    }
}
