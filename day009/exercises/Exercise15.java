package exercises;

import java.util.Arrays;

public class Exercise15 {
    public static int[] generateEvenArray(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = (i + 1) * 2;
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateEvenArray(5))); // [2, 4, 6, 8, 10]
    }
}
