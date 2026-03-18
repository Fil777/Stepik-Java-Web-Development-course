import java.util.HashMap;

public class Ex09FrequencyDictionary {
    public static void main(String[] args) {
        // Исходный текст для анализа
        String text = "Далеко-далеко за словесными горами в стране гласных и согласных живут рыбные тексты.";

        // Создаем HashMap для хранения частоты букв
        HashMap<Character, Integer> dict = new HashMap<>();

        // Проходим по каждому символу в тексте
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Проверяем, является ли символ буквой
            if (Character.isLetter(ch)) {
                // Приводим букву к нижнему регистру
                ch = Character.toLowerCase(ch);
                // Если буква уже есть в словаре, увеличиваем счетчик
                if (dict.containsKey(ch)) {
                    dict.put(ch, dict.get(ch) + 1);
                } else {
                    // Если буквы нет в словаре, добавляем ее со значением 1
                    dict.put(ch, 1);
                }
            }
        }

        // Выводим весь словарь
        System.out.println(dict);

        // Выводим каждую пару ключ-значение в отдельной строке
        for (var pair : dict.entrySet()) {
            System.out.printf("[%s -> %d]\n", pair.getKey(), pair.getValue());
        }
    }
}
