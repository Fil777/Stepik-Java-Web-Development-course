package exercises;

public class Exercise19 {
    public static double findClosestToAverage(double[] array) {
        if (array.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double num : array) {
            sum += num;
        }

        double average = sum / array.length;
        double closest = array[0];
        double minDiff = Math.abs(array[0] - average);

        for (int i = 1; i < array.length; i++) {
            double diff = Math.abs(array[i] - average);
            if (diff < minDiff) {
                minDiff = diff;
                closest = array[i];
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        double[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println(findClosestToAverage(array));
    }
}
