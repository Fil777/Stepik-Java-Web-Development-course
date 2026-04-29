package stepik.course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        String header = "Bearer 123456";
        if (header.isEmpty() || !header.substring(0, 7).equals("Bearer ")){
            System.out.println("'" + header.substring(0, 7) + "'");
            System.out.println("Header is empty or incorrect");
        } else {
            System.out.println("Header is correct");
            System.out.println(header.substring(7));
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println("\nСейчас: "+ sdf.format(date));

        LocalDate localDate = LocalDate.ofInstant(new Date().toInstant(), ZoneId.of("Europe/Moscow"));

        //LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("Сегодня: " + localDate + " zone = " + ZoneId.systemDefault());

        long ts = System.currentTimeMillis()/1000;
        System.out.println("\nТекущее время в секундах с 1970: " + ts);
        System.out.println("Текущее время в миллисекундах: " + System.currentTimeMillis());
        Date currDate = new Date(ts * 1000);
        System.out.println("Текущее время : " + sdf.format(currDate));

        long ts1 = 1798750800;
        long ts2 = 1803762000;

        LocalDate localDate1 = Instant.ofEpochMilli(ts1 * 1000)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate localDate2 = Instant.ofEpochMilli(ts2 * 1000)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        System.out.println("\nStart date = " + localDate1 + "\nEnd date   = " + localDate2);
        System.out.println("Дней между датами: " + ChronoUnit.DAYS.between(localDate1, localDate2) + "\n");


        Date sDate = new Date (ts1 * 1000); // 01/01/2027
        Date eDate = new Date (ts2 * 1000); // 28/02/2027

        String date1 = dateFormat.format(sDate);
        String date2 = dateFormat.format(eDate);

        System.out.println("\nStart date = " + dateFormat.format(sDate)
                + "\nEnd date   = " +dateFormat.format(eDate));
        System.out.println("Дней между датами: " + ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)) + "\n");

        LocalDate startDay = LocalDate.parse("2027-01-01");
        LocalDate endDay = LocalDate.parse("2027-02-28");
        long diffInDays = startDay.until(endDay, ChronoUnit.DAYS);
        System.out.println(startDay + " - " + endDay + " = " + diffInDays + " дней\n");

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