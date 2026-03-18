import java.util.ArrayList;
import java.util.Scanner;

public class Ex02ShoppingList {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Создаем список покупок типа ArrayList<String>
        ArrayList<String> shoppingList = new ArrayList<>();

        // Выводим инструкцию для пользователя
        System.out.println("Введите покупки или 'конец' для окончания ввода");

        // Бесконечный цикл для ввода покупок
        while (true) {
            // Запрашиваем у пользователя ввод покупки
            System.out.print("Добавление: ");
            String item = scanner.nextLine();

            // Проверяем, если пользователь ввел 'конец', то завершаем ввод
            if (item.equalsIgnoreCase("конец")) {
                // Выводим список покупок
                for (String product : shoppingList) {
                    System.out.println(product);
                }

                // Закрываем Scanner
                scanner.close();
                // Завершаем программу
                return;
            }

            // Добавляем введенную покупку в список
            shoppingList.add(item);
        }
    }
}
