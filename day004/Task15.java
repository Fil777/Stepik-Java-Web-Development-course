public class Task15 {
    public static void main(String[] args) {
        int fibonacci = 1;
        int a = 1;
        int b = 0;
        for (int i = 0; i < 20; i++) {
            System.out.printf("%d ", fibonacci);
            a = b;
            b = fibonacci;
            fibonacci = a + b;
        }
        System.out.println("\nГотово!");
    }
}
