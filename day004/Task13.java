public class Task13 {
    public static void main(String[] args) throws Exception {

        for (int i = 10; i > 0; i--) {
            System.out.printf("%d ", i);
            Thread.sleep(1000); // Пауза в 1 секунду
        }
        System.out.println("\nСтарт!\n");
    }
}
