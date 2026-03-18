import java.util.Scanner;

public class Ex03CharacterCount {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        // Преобразуем введенную строку в нижний регистр для регистронезависимого поиска
        String lowerCase = input.toLowerCase();

        // Запрашиваем у пользователя символ для поиска
        System.out.print("Введите символ для поиска: ");
        // Считываем первый символ введенной строки и преобразуем его в нижний регистр
        char searchChar = Character.toLowerCase(scanner.next().charAt(0));

        // Инициализируем счетчик найденных символов
        int found = 0;

        // Проходим по каждому символу в строке
        for (int i = 0; i < input.length(); i++) {
            // Если текущий символ совпадает с искомым, увеличиваем счетчик
            if (lowerCase.charAt(i) == searchChar) {
                found++;
            }
        }

        // Выводим результат: исходную строку и количество найденных символов
        System.out.printf("%s -> %d\n", input, found);

        // Закрываем Scanner для освобождения ресурсов
        scanner.close();
    }
}
