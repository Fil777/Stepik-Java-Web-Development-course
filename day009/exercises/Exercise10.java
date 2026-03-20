package exercises;

import java.util.Arrays;
import java.util.Random;

public class Exercise10 {
    public static int[] generateArrayWithEvenNumbers(int n, int m) {
        if (m > n) {
            return new int[0];
        }

        Random random = new Random();
        int[] array = new int[n];
        int evenCount = 0;

        for (int i = 0; i < n; i++) {
            if (evenCount < m) {
                array[i] = random.nextInt(50) * 2;
                evenCount++;
            } else {
                array[i] = random.nextInt(50) * 2 + 1;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArrayWithEvenNumbers(10, 6))); // массив из 10 чисел, 6 из которых
                                                                                  // четные
        System.out.println(Arrays.toString(generateArrayWithEvenNumbers(8, 4))); // массив из 8 чисел, 4 из которых
                                                                                 // четные
    }
}
