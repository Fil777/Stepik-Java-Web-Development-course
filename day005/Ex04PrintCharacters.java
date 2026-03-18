import java.util.Scanner; // Импорт класса Scanner для ввода данных

public class Ex04PrintCharacters {
    public static void main(String[] args) {
        // Создание объекта Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Вывод приглашения для ввода строки
        System.out.print("Введите строку: ");

        // Чтение введенной пользователем строки
        String input = scanner.nextLine();

        // Вывод заголовка перед выводом символов
        System.out.println("Символы строки:");

        // Цикл для перебора всех символов в введенной строке
        for (int i = 0; i < input.length(); i++) {
            // Вывод каждого символа на новой строке
            System.out.println(input.charAt(i));
        }

        // Закрытие объекта Scanner для освобождения ресурсов
        scanner.close();
    }
}
