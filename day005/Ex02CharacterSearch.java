import java.util.Scanner;

public class Ex02CharacterSearch {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        // Запрашиваем у пользователя ввод символа для поиска
        System.out.print("Введите символ для поиска: ");
        char searchChar = scanner.next().charAt(0);

        // Перебираем каждый символ во введенной строке
        for (int i = 0; i < input.length(); i++) {
            // Если текущий символ совпадает с искомым
            if (input.charAt(i) == searchChar) {
                // Выводим строку и true, так как символ найден
                System.out.printf("%s -> true\n", input);
                // Закрываем Scanner
                scanner.close();
                // Завершаем выполнение метода
                return;
            }
        }

        // Если цикл завершился без нахождения символа, выводим строку и false
        System.out.printf("%s -> false\n", input);

        // Закрываем Scanner
        scanner.close();
    }
}
