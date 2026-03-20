import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03File {
    public static void main(String[] args) throws IOException {

        // Объявление переменной path с путем к файлу
        String path = "data.txt";
        // Создание объекта File с указанным путем
        File file = new File(path);

        // Создание объекта FileWriter с использованием try-with-resources
        try (FileWriter fw = new FileWriter(file)) {
            // Объявление переменной count со значением 5
            int count = 5;
            // Цикл, пока count больше 0
            while (count-- > 0) {
                // Запись строки в файл с помощью FileWriter
                fw.write("Строка " + count + "\n");
            }
        }
    }

    // Объявление метода fileWrite с обработкой исключения IOException
    static void fileWrite() throws IOException {
        // Объявление переменной path с путем к файлу
        String path = "data.txt";
        // Создание объекта File с указанным путем
        File file = new File(path);

        // Создание объекта FileWriter
        FileWriter fw = new FileWriter(file);
        // Объявление переменной count со значением 5
        int count = 5;
        // Цикл, пока count больше 0
        while (count-- > 0) {
            // Запись строки в файл с помощью FileWriter
            fw.write("Строка " + count + "\n");
        }

        // Сброс буфера FileWriter
        fw.flush();
        // Закрытие FileWriter
        fw.close();
    }

    // Объявление метода fileReader с обработкой исключения IOException
    static void fileReader() throws IOException {
        // Объявление переменной path с путем к файлу
        String path = "data.txt";
        // Создание объекта File с указанным путем
        File file = new File(path);
        // Создание объекта FileReader
        FileReader fr = new FileReader(file);
        // Создание объекта BufferedReader с использованием FileReader
        BufferedReader br = new BufferedReader(fr);

        // Объявление переменной line для хранения прочитанной строки
        String line;
        // Цикл, пока есть строки для чтения
        while ((line = br.readLine()) != null) {
            // Вывод прочитанной строки на консоль
            System.out.println(line);
        }

        // Закрытие BufferedReader
        br.close();
        // Закрытие FileReader
        fr.close();
    }

    // Объявление метода file с обработкой исключения IOException
    static void file() throws IOException {
        // Объявление переменной path с текущей директорией
        String path = ".";
        // Создание объекта File с указанным путем
        File file = new File(path);
        // Проверка существования файла и вывод результата на консоль
        System.out.println(file.exists());
        // Создание нового файла
        file.createNewFile();
        // Удаление файла
        file.delete();
        // Проверка, является ли файл директорией, и вывод результата на консоль
        System.out.println(file.isDirectory());
        // Получение списка файлов в директории
        File[] list = file.listFiles();

        // Цикл по списку файлов
        for (File f : list) {
            // Вывод имени каждого файла на консоль
            System.out.println(f.getName());
        }
    }
}
