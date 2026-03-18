import java.util.Scanner;

public class Ex06UppercaseCheck {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Проходим по каждому символу строки
        for (int i = 0; i < input.length(); i++) {
            // Проверяем, является ли текущий символ заглавной буквой
            if (Character.isUpperCase(input.charAt(i))) {
                // Если найдена заглавная буква, выводим "true" и завершаем программу
                System.out.printf("%s -> true\n", input);
                scanner.close();
                return;
            }
        }

        // Если заглавных букв не найдено, выводим "false"
        System.out.printf("%s -> false\n", input);

        // Закрываем Scanner
        scanner.close();
    }
}
