import java.util.Scanner;

public class Ex01StringLength {
    public static void main(String[] args) {
        // Создание объекта Scanner для чтения ввода с консоли
        Scanner scanner = new Scanner(System.in);

        // Вывод приглашения для ввода строки
        System.out.print("Введите строку: ");

        // Чтение строки с консоли
        String input = scanner.nextLine();

        // Инициализация счетчика символов
        int count = 0;

        // Цикл для перебора символов в строке
        for (int i = 0; i < input.length(); i++) {
            // Получение текущего символа
            char ch = input.charAt(i);

            // Проверка, является ли символ буквой или цифрой
            if (ch != ' ' && ch != '.' && ch != ',') {
                // Увеличение счетчика, если символ является буквой или цифрой
                count++;
            }
        }

        // Вывод результата
        System.out.printf("%s -> %d\n", input, count);

        // Закрытие объекта Scanner
        scanner.close();
    }
}
