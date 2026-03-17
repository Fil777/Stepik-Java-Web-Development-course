// Класс, который содержит "точку входа" в приложение
public class Ex01HelloWorldProgram {
    // Главный метод, с которого начинается выполнение программы
    // "Точка входа"
    public static void main(String[] args) {
        // Выводит строку "Hello world!" без перехода на новую строку
        System.out.print("Hello world!\"\n");

        // Вычисляет сумму 1 + 2 и выводит результат (3) на новой строке
        System.out.println(1 + 2);

        // Объявление и инициализация целочисленной переменной index значением 1
        int index = 1;

        // Объявление и инициализация строки text значением "Hello world"
        String text = "Hello world";

        // Извлечение символа из строки text по индексу 1 (второй символ)
        char symbol = text.charAt(index);

        // Вывод извлеченного символа ('e') на новой строке
        System.out.println(symbol);
    }
}
