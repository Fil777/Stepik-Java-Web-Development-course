import java.util.ArrayList;
import java.util.Scanner;

public class Ex04RemoveDuplicates {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Создаем ArrayList для хранения слов без дубликатов
        ArrayList<String> words = new ArrayList<>();

        // Бесконечный цикл для ввода слов
        while (true) {
            System.out.print("Введите слово: ");
            // Читаем слово, введенное пользователем
            String word = scanner.nextLine();

            // Если пользователь ввел "конец", завершаем программу
            if (word.equalsIgnoreCase("конец")) {
                System.out.println("Список без дубликатов: " + words);
                scanner.close();
                return;
            }

            // Проверяем, содержится ли слово уже в списке
            if (!words.contains(word)) {
                // Если слово не содержится, добавляем его в список
                words.add(word);
            }
        }
    }
}
