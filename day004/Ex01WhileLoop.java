import java.util.Scanner;

public class Ex01WhileLoop {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с консоли
        Scanner scanner = new Scanner(System.in);

        // Инициализируем переменные для подсчета количества итераций
        int count = 0;
        // и суммы
        int sum = 0;

        // Цикл while будет выполняться, пока count меньше 10
        while (count < 10) {
            // Выводим сообщение с номером текущей итерации
            System.out.printf("Введите %d-е значение: ", count);
            // Читаем целое число, введенное пользователем
            int value = scanner.nextInt();
            // Добавляем введенное число к сумме
            sum += value;
            // Увеличиваем счетчик итераций на 1
            count++;
        }

        // Выводим итоговую сумму
        System.out.printf("Сумма = %d\n", sum);
        // Закрываем объект Scanner
        scanner.close();
    }
}
