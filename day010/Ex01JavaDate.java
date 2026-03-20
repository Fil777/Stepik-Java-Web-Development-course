import java.time.*;
import java.time.format.DateTimeFormatter;

public class Ex01JavaDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate date = LocalDate.of(2025, Month.OCTOBER, 20);
        System.out.println(date);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime time = LocalTime.of(10, 20, 30, 4000);
        System.out.println(time);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime dateTime = LocalDateTime.of(2028, Month.NOVEMBER, 15, 13, 22, 54, 100);
        System.out.println(dateTime);

        for (var zone : ZoneId.getAvailableZoneIds()) {
            System.out.println(zone);
        }

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZonedDateTime zoned = ZonedDateTime.of(
                2030, 10, 10, 12, 13, 14, 15, ZoneId.of("Europe/Monaco"));
        System.out.println(zoned);

        //
        LocalTime startTime = LocalTime.now();

        double sum = 0;
        while (sum < 10_000_000) {
            sum += 1.0;
        }

        LocalTime endTime = LocalTime.now();

        System.out.println(startTime);
        System.out.println(endTime);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println(duration.toMillis());

        LocalDate startDate = LocalDate.of(2029, 10, 1);
        LocalDate endDate = LocalDate.of(2030, 10, 3);

        Period period = Period.between(startDate, endDate);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getDays());

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDateTime = dateTimeFormatter.format(currentDateTime);

        System.out.println(currentDateTime);
        System.out.println(formattedDateTime);

    }
}
