import java.util.ArrayList;
import java.util.Random;

public class Ex01ArrayList {
    public static void main(String[] args) {
        Random random = new Random();

        // Создаем ArrayList для хранения целых чисел
        ArrayList<Integer> list = new ArrayList<>();

        // Заполняем список тремя случайными числами от 0 до 9
        for (int i = 0; i < 3; i++) {
            list.add(random.nextInt(10));
        }

        // Выводим исходный список
        System.out.println("Исходный список: " + list);

        // Умножаем каждый элемент списка на 10
        for (int i = 0; i < list.size(); i++) {
            int item = list.get(i);
            list.set(i, item * 10);
            System.out.println("Элемент " + i + " после умножения: " + item * 10);
        }

        // Попытка изменить элементы списка через for-each цикл (не работает)
        for (Integer item : list) {
            // !!! Это не изменит элементы в списке, так как item - это копия значения
            item = 1000;
            System.out.println("Попытка изменить на: " + item);
        }
        System.out.println("Список после попытки изменения: " + list);

        // Проверяем, содержит ли список число 0
        System.out.println("Список содержит 0: " + list.contains(0));

        // Создаем новый ArrayList для хранения чисел с плавающей точкой
        ArrayList<Double> doubles = new ArrayList<>();

        // Примеры дополнительных методов ArrayList

        // Добавляем элементы в список doubles
        doubles.add(3.14);
        doubles.add(2.71);
        doubles.add(1.41);
        System.out.println("Список doubles: " + doubles);

        // Удаляем элемент по индексу
        doubles.remove(1);
        System.out.println("Список doubles после удаления второго элемента: " + doubles);

        // Проверяем, пуст ли список
        System.out.println("Список doubles пуст: " + doubles.isEmpty());

        // Очищаем список
        doubles.clear();
        System.out.println("Список doubles после очистки: " + doubles);

        // Добавляем все элементы из list в doubles (с приведением типов)
        for (Integer num : list) {
            doubles.add(num.doubleValue());
        }
        System.out.println("Список doubles после добавления элементов из list: " + doubles);

        // Получаем размер списка
        System.out.println("Размер списка doubles: " + doubles.size());
    }
}
