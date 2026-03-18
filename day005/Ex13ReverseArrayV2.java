import java.util.Arrays;

public class Ex13ReverseArrayV2 {
    public static void main(String[] args) {
        // int x = 1;
        // int y = 2;
        // System.out.println("x = " + x);
        // System.out.println("y = " + y);

        // int t = x;
        // x = y;
        // y = t;

        // System.out.println("x = " + x);
        // System.out.println("y = " + y);

        String[] dayOfWeek = {
                "Понедельник",
                "Вторник",
                "Среда",
                "Четверг",
                "Пятница",
                "Суббота",
                "Воскресенье",
        };
        System.out.println(Arrays.toString(dayOfWeek));

        for (int i = 0; i < dayOfWeek.length / 2; i++) {
            String temp = dayOfWeek[i];
            dayOfWeek[i] = dayOfWeek[dayOfWeek.length - 1 - i];
            dayOfWeek[dayOfWeek.length - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(dayOfWeek));
    }
}
