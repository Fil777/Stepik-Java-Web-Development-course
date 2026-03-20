package exercises;

import java.util.Arrays;

public class Exercise12 {
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }

        return reversed;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(reverseArray(array))); // [5, 4, 3, 2, 1]
    }
}
