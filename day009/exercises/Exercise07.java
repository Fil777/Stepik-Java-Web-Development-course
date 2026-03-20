package exercises;

import java.util.Arrays;

public class Exercise07 {
    public static int[] fibonacci(int n) {
        int[] fib = new int[n];

        if (n > 0) {
            fib[0] = 0;
        }

        if (n > 1) {
            fib[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(0))); // []
        System.out.println(Arrays.toString(fibonacci(1))); // [0]
        System.out.println(Arrays.toString(fibonacci(2))); // [0, 1]
        System.out.println(Arrays.toString(fibonacci(3))); // [0, 1, 1]
        System.out.println(Arrays.toString(fibonacci(5))); // [0, 1, 1, 2, 3]
        System.out.println(Arrays.toString(fibonacci(10))); // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    }
}
