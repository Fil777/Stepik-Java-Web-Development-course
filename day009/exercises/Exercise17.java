package exercises;

import java.util.Arrays;

public class Exercise17 {
    public static int[] generateSumArray(int n) {
        int[] array = new int[n];

        array[0] = 0;
        for (int i = 1; i < n; i++) {
            array[i] = i + array[i - 1];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateSumArray(5))); // [0, 1, 3, 6, 10]
    }
}
