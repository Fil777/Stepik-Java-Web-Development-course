import java.util.Random;

public class Ex14AdvancedPrimeNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10, 1000);

        for (int number = 2; number < n; number++) {

            int div = 0;

            for (int i = 2; i < number - 1; i++) {
                if (number % i == 0) {
                    div++;
                }
            }

            if (div == 0) {
                System.out.printf("%d ", number);
            }
        }

        System.out.println();
    }

}
