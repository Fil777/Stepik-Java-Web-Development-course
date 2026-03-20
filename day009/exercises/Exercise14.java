package exercises;

public class Exercise14 {
    public static int getDifferenceBetweenMaxAndMin(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }

        return max - min;
    }

    public static void main(String[] args) {
        int[] array = { 10, 5, 7, 12, 3, 8 };
        System.out.println(getDifferenceBetweenMaxAndMin(array)); // 9
    }
}
