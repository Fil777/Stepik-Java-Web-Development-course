import java.io.Console;

public class Ex06ConsoleDataInput {
    public static void main(String[] args) {
        // Получаем объект Console для чтения данных с консоли
        Console console = System.console();

        // Читаем строку с консоли, выводя приглашение "Введите ваше имя: "
        String name = console.readLine("Введите ваше имя: ");
        // Выводим приветствие, используя введенное имя
        System.out.println("Привет, " + name);

        // Читаем пароль с консоли, выводя приглашение "Введите пароль"
        // Введенные символы не будут отображаться на экране
        char[] password = console.readPassword("Введите пароль: ");
        // Выводим введенный пароль, используя форматированный вывод
        System.out.printf("Пароль: %s\n", new String(password));

        // Проходим по каждому символу массива password
        for (char c : password) {
            // Выводим каждый символ пароля на отдельной строке
            System.out.println(c);
        }
    }
}
