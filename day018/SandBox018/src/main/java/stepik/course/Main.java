package stepik.course;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.time.LocalTime.now;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Сейчас: "+ sdf.format(date));

        Date sDate = new Date (1798750800);
        Date eDate = new Date (1803762000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date1 = dateFormat.format(sDate);
        String date2 = dateFormat.format(eDate);
        System.out.println("\nStart date = " + date1 + "\nEnd date   = " + date2);
        System.out.println("Дней между датами: " + ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)) + "\n");

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