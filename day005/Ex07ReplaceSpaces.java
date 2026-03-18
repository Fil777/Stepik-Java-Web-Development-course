import java.util.Scanner;

public class Ex07ReplaceSpaces {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с консоли
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine().trim();

        // Создаем StringBuilder для построения результирующей строки
        StringBuilder result = new StringBuilder();

        // Флаг, указывающий, был ли предыдущий символ пробелом
        boolean lastWasSpace = false;

        // Проходим по каждому символу входной строки
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Если текущий символ - пробел
            if (ch == ' ') {
                // Если предыдущий символ не был пробелом, добавляем '_' в результат
                if (!lastWasSpace) {
                    result.append("_");
                    lastWasSpace = true;
                }
            } else {
                // Если текущий символ не пробел, добавляем его в результат
                result.append(ch);
                lastWasSpace = false;
            }
        }

        // Выводим исходную строку и результирующую строку
        System.out.printf("%s -> %s\n", input, result.toString());

        // Закрываем Scanner
        scanner.close();
    }
}
