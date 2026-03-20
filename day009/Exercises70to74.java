import java.util.ArrayList;

public class Exercises70to74 {
    public static void main(String[] args) {

        int[] tetsArray = { 1, 2, 0, 4, 0, 5 };
        for (int i : compressArray(tetsArray)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        int[] testArray = { 1, 2, 0, 4, 0, 5 };
        for (int i : reverseArray(testArray)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i : generateSquareArray(11)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        System.out.println(getDifferenceBetweenMaxAndMin(
                new int[] { 7, -3, 8, 8, -2, 5 }));

        for (int i : generateEvenArray(8)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }

    // 70
    static int[] compressArray(int[] array) {
        ArrayList<Integer> noZerosList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                noZerosList.add(array[i]);
            }
        }
        int[] result = new int[noZerosList.size()];
        for (int i = 0; i < noZerosList.size(); i++) {
            result[i] = noZerosList.get(i);
        }
        return result;
    }

    // 71
    static int[] reverseArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }

    // 72
    static int[] generateSquareArray(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i] = i * i;
        }
        return result;
    }

    // 73
    static int getDifferenceBetweenMaxAndMin(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int n : array) {
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        return max - min;
    }

    // 74
    static int[] generateEvenArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i * 2 + 2;
        }
        return result;
    }

}