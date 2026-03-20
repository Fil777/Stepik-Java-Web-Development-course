import java.util.ArrayList;
import java.util.Random;

public class Exercises65to69 {
    public static void main(String[] args) {

        System.out.println(countDigits(1949598883));

        for (long l : fibonacci(22)) {
            System.out.printf("%d ", l);
        }
        System.out.println();

        System.out.println(isPrime(61));

        for (int i : getDivisors(154618)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i : generateArrayWithEvenNumbers(7, 6)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }

    // 65
    static int countDigits(long n) {
        String s = Long.toString(Math.abs(n));
        return s.length();
    }

    // 66
    static int[] fibonacci(int n) {
        if (n < 0) {
            return new int[] {};
        }
        if (n == 0) {
            return new int[] { 0 };
        }
        if (n == 1) {
            return new int[] { 0, 1 };
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    // 67
    static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 68
    static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        if (n > 0) {
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                }
            }
        }
        divisors.add(n);
        return divisors;
    }

    // 69
    static int[] generateArrayWithEvenNumbers(int n, int m) {
        int[] result = new int[n];
        Random random = new Random();
        while (true) {
            int evens = 0;
            for (int i = 0; i < n; i++) {
                result[i] = random.nextInt(100);
                if (result[i] % 2 == 0) {
                    evens++;
                }
            }
            if (evens == m) {
                break;
            }
        }
        return result;
    }
}
