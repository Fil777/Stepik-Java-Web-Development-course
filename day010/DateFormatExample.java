import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatExample {
    public static void main(String[] args) {
        // Используем ZonedDateTime вместо LocalDateTime
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Создаем форматтер с полным форматом даты и времени
        String format = "EEEE, dd MMMM, yyyy HH:mm:ss z";
        // четверг, 29 января, 2036 07:07:26 MSK
        DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern(format, Locale.forLanguageTag("ru"));

        // Форматируем дату и время
        String formattedDateTime = currentDateTime.format(fullFormatter);

        // Выводим результат
        System.out.println("Полный формат даты и времени:");
        System.out.println(formattedDateTime);
    }
}
