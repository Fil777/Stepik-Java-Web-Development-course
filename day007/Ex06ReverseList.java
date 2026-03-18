import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex06ReverseList {
    public static void main(String[] args) {
        // Создание объекта Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Инициализация ArrayList для хранения введенных слов
        ArrayList<String> words = new ArrayList<>();

        while (true) {
            System.out.print("Введите слово: ");
            // Чтение слова, введенного пользователем
            String word = scanner.nextLine();

            // Проверка на ключевое слово для завершения ввода
            if (word.equalsIgnoreCase("конец")) {
                // Создание копии списка words для реверсирования
                ArrayList<String> reversedList = new ArrayList<>(words);

                // Реверсирование списка с использованием метода Collections.reverse()
                Collections.reverse(reversedList);

                // Вывод исходного и реверсированного списков
                System.out.println("Слова: " + words);
                System.out.println("Реверс: " + reversedList);

                // Закрытие Scanner и завершение программы
                scanner.close();
                return;
            }

            // Добавление слова в список, если оно еще не присутствует
            if (!words.contains(word)) {
                words.add(word);
            }
        }
    }
}
