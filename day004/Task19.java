public class Task19 {
    public static void main(String[] args) {

        for (int value = 2; value <= 200; value++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.printf("%4d ", value);
            }
        }
        System.out.println();
    }
}
