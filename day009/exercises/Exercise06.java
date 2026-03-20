package exercises;

public class Exercise06 {
    public static int countDigits(int number) {
        number = Math.abs(number);

        if (number < 10) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(0)); // 1
        System.out.println(countDigits(45)); // 2
        System.out.println(countDigits(-12345)); // 5
    }
}
