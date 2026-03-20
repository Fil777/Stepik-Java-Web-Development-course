package exercises;

import java.util.ArrayList;

public class Exercise16 {
    public static ArrayList<Integer> findIndexes(int[] array, int number) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 2, 4, 2, 5 };
        System.out.println(findIndexes(array, 2)); // [1, 3, 5]
        System.out.println(findIndexes(array, 5)); // [6]
        System.out.println(findIndexes(array, 6)); // []
    }
}
