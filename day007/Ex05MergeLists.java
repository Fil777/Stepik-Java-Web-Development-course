import java.util.ArrayList;
import java.util.Random;

public class Ex05MergeLists {
    public static void main(String[] args) {
        // Создаем два пустых списка целых чисел
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();
        int min = 2, max = 5;

        // Заполняем list1 случайным количеством (от 2 до 4) случайных чисел от 0 до 99
        for (int i = 0; i < random.nextInt(min, max); i++) {
            list1.add(random.nextInt(100));
        }
        // Заполняем list2 случайным количеством (от 2 до 4) случайных чисел от 0 до 99
        for (int i = 0; i < random.nextInt(min, max); i++) {
            list2.add(random.nextInt(100));
        }

        // Создаем новый список для объединения list1 и list2
        ArrayList<Integer> mergedList = new ArrayList<>();
        // Добавляем все элементы из list1 в mergedList
        mergedList.addAll(list1);
        // Альтернативный способ добавления элементов (закомментирован):
        // for (Integer item : list1) {
        // mergedList.add(item);
        // }

        // Добавляем все элементы из list2 в mergedList
        mergedList.addAll(list2);
        // Альтернативный способ добавления элементов (закомментирован):
        // for (Integer item : list2) {
        // mergedList.add(item);
        // }

        // Выводим содержимое всех списков
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("merged: " + mergedList);
    }
}
