import java.util.Arrays;

public class Ex12ReverseArrayV1 {
    public static void main(String[] args) {

        // int count = 7;
        // String[] dayOfWeek = new String[count];
        // dayOfWeek[0] = "Понедельник";
        // dayOfWeek[1] = "Вторник";
        // dayOfWeek[2] = "Среда";
        // dayOfWeek[3] = "Четверг";
        // dayOfWeek[4] = "Пятница";
        // dayOfWeek[5] = "Суббота";
        // dayOfWeek[6] = "Воскресенье";

        String[] dayOfWeek = {
                "Понедельник",
                "Вторник",
                "Среда",
                "Четверг",
                "Пятница",
                "Суббота",
                "Воскресенье",
        };

        String[] reverseDayOfWeek = new String[dayOfWeek.length];
        int lastIndex = reverseDayOfWeek.length - 1;

        for (int i = 0; i < dayOfWeek.length; i++) {
            reverseDayOfWeek[lastIndex--] = dayOfWeek[i];
        }

        System.out.println(Arrays.toString(dayOfWeek));
        System.out.println(Arrays.toString(reverseDayOfWeek));

    }
}
