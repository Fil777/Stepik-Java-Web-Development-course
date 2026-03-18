import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05BufferedReaderDataInput {
    public static void main(String[] args) throws IOException {
        // Создаем объект BufferedReader для чтения данных с консоли
        // Используем InputStreamReader для преобразования байтов в символы
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Выводим приглашение для ввода имени
        System.out.print("Введите ваше имя: ");
        // Читаем строку с помощью метода readLine() и сохраняем ее в переменную name
        String name = reader.readLine();

        // Выводим приглашение для ввода возраста
        System.out.print("Введите ваш возраст: ");
        // Читаем строку с помощью метода readLine(), преобразуем ее в целое число
        // с помощью метода Integer.parseInt() и сохраняем в переменную age
        int age = Integer.parseInt(reader.readLine());

        // Выводим приветствие, используя введенные имя и возраст
        // Добавляем 1 к возрасту, чтобы показать возраст в следующем году
        System.out.println("Привет, " + name + "! " + (age + 1));

        // Закрываем BufferedReader, чтобы освободить ресурсы
        reader.close();
    }
}
