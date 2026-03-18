import java.util.Random;

public class Ex03Random {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(10);
            System.out.println(value);
        }
    }
}
