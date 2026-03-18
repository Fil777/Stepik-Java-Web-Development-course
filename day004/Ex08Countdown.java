public class Ex08Countdown {
    public static void main(String[] args) throws Exception {

        for (int i = 10; i > 0; i--) {
            System.out.printf("%d ", i);

            // double delay = 0;
            // while (delay < 250_000_000) {
            // delay++;
            // }

            Thread.sleep(2500);
        }

        System.out.println("\nСтарт!");
    }
}
