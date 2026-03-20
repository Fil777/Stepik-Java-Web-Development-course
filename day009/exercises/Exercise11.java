package exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise11 {
    public static int[] compressArray(int[] array) {
        ArrayList<Integer> compressed = new ArrayList<>();
        for (int num : array) {
            if (num != 0) {
                compressed.add(num);
            }
        }

        int[] result = new int[compressed.size()];
        for (int i = 0; i < compressed.size(); i++) {
            result[i] = compressed.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 0, 2, 0, 3, 0, 4, 0, 5 };
        System.out.println(Arrays.toString(compressArray(array))); // [1, 2, 3, 4, 5]
    }
}
