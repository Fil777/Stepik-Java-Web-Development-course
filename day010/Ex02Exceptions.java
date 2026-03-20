
// Импорт необходимых классов для работы с файлами и обработки исключений
import java.io.FileWriter;
import java.io.IOException;

public class Ex02Exceptions {
    public static void main(String[] args) {
        // Создание массива целых чисел размером 1
        int[] arr = new int[1];

        try {
            // Попытка преобразовать строку "1" в целое число и присвоить его первому
            // элементу массива
            arr[0] = Integer.parseInt("1");
            System.out.println("ok");
        } catch (NumberFormatException e) {
            // Обработка исключения, если строка не может быть преобразована в целое число
            System.out.println("данные кривые");
        } catch (IndexOutOfBoundsException e) {
            // Обработка исключения, если индекс выходит за границы массива
            System.out.println("индекс кривой");
        }

        // Вывод сообщений после блока try-catch
        System.out.println("step 1");
        System.out.println("step 2");
        System.out.println("step 3");

        // Вызов метода writeFile() для записи в файл
        writeFile();
    }

    static void writeFile() {
        // Путь к файлу
        String path = "file.txt";

        // Содержимое, которое будет записано в файл
        String content = "Какой-то текст";

        FileWriter writer;
        try {
            // Создание объекта FileWriter для записи в файл
            writer = new FileWriter(path);
            // Запись содержимого в файл
            writer.write(content);
            // Закрытие файла
            writer.close();
        } catch (IOException e) {
            // Обработка исключения, если возникла ошибка при работе с файлом
            System.out.println("Ошибка при работе с файлом");
            // Вывод трассировки стека исключения
            System.out.println(e.getStackTrace());
            // Вывод сообщения об ошибке
            System.out.println(e.getMessage());
        }
    }
}
