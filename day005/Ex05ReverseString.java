import java.util.Scanner;

public class Ex05ReverseString {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Создаем объект StringBuilder для эффективной работы со строками
        StringBuilder sb = new StringBuilder();

        // Проходим по символам введенной строки в обратном порядке
        for (int i = input.length() - 1; i >= 0; i--) {
            // Добавляем каждый символ в StringBuilder
            sb.append(input.charAt(i));
        }

        // Выводим исходную строку и ее обратную версию
        System.out.printf("%s -> %s\n", input, sb.toString());

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }
}
