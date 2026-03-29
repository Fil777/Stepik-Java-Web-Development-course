package stepik.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Deque<String> stack = new ArrayDeque<>();

        stack.push("Первый");
        stack.push("Второй");
        stack.push("Третий");

//        System.out.println(stack.peek()); // Третий
//        System.out.println(stack.pop());  // Третий
//

        String fileName = "output.txt";

        try {
            Files.write(Paths.get(fileName), stack);
            System.out.println("Файл успешно записан.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                stack.push(line);
//            }
//        } catch (IOException e) {
//            System.err.println("Ошибка при чтении файла: " + e.getMessage());
//        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("Файл успешно считан.");
            for (String line : lines) {
                stack.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}