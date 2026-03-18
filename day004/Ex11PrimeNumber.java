import java.util.Random;

public class Ex11PrimeNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(2, 10000);

        int div = 0;

        StringBuilder sb = new StringBuilder();
        String s = "";
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                div++;
                sb.append(String.format("[%d] ", i));
                s += String.format("[%d] ", i);
            }
        }

        if (div != 0) {
            System.out.printf("%d - не является простым числом\n", number);
            System.out.println(sb.toString());
            System.out.println(s);
        } else {
            System.out.printf("%d - является простым числом\n", number);
        }
    }
}
