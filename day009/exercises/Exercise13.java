package exercises;

import java.util.Arrays;

public class Exercise13 {
    public static int[] generateSquareArray(int n) {
        if (n < 0) {
            return new int[0];
        }

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i * i;
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateSquareArray(-1))); // []
        System.out.println(Arrays.toString(generateSquareArray(5))); // [0, 1, 4, 9, 16]
    }
}
