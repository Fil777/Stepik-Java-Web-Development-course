import java.util.ArrayList;
import java.util.HashMap;

public class Exercises80to84 {
    public static void main(String[] args) {

        for (int i : findIndexes(
                new int[] { 4, 2, 2, 3, 2, 2, 1, 4 }, 2)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i : generateSumArray(6)) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        HashMap<String, ArrayList<Integer>> map = separateEvenOdd(
                new int[] { 5, -6, -9, 7, 7, -2, -4, -2 });
        System.out.println(map.toString());

        System.out.println(findClosestToAverage(
                new double[] { 0.25, -0.25, 1.0, 5.25, -8.0, 9.0, -2.75 }));

        HashMap<String, Integer> map2 = countNumberTypes(
                new int[] { -4, -2, -5, 0, 2 });
        System.out.println(map2.toString());
    }

    // 80
    static ArrayList<Integer> findIndexes(int[] array, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                list.add(i);
            }
        }
        return list;
    }

    // 81
    static int[] generateSumArray(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i] = i + result[i - 1];
        }
        return result;
    }

    // 82
    static HashMap<String, ArrayList<Integer>> separateEvenOdd(int[] array) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        map.put("even", new ArrayList<>());
        map.put("odd", new ArrayList<>());
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                map.get("even").add(array[i]);
            } else {
                map.get("odd").add(array[i]);
            }
        }
        return map;
    }

    // 83
    static double findClosestToAverage(double[] array) {
        double sum = 0.0;
        for (double element : array) {
            sum += element;
        }
        double avg = sum / array.length;
        double closest = array[0];
        for (double element : array) {
            if (Math.abs(element - avg) < Math.abs(closest - avg)) {
                closest = element;
            }
        }
        return closest;
    }

    // 84
    static HashMap<String, Integer> countNumberTypesGood(int[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                map.put("positive", map.getOrDefault("positive", 0) + 1);
            } else if (array[i] < 0) {
                map.put("negative", map.getOrDefault("negative", 0) + 1);
            } else {
                map.put("zero", map.getOrDefault("zero", 0) + 1);
            }
        }
        return map;
    }

    static HashMap<String, Integer> countNumberTypes(int[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("positive", 0);
        map.put("negative", 0);
        map.put("zero", 0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                map.put("positive", map.get("positive") + 1);
            } else if (array[i] < 0) {
                map.put("negative", map.get("negative") + 1);
            } else {
                map.put("zero", map.get("zero") + 1);
            }
        }
        return map;
    }
}