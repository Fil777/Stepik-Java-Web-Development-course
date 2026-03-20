package exercises;

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise18 {
    public static HashMap<String, ArrayList<Integer>> separateEvenOdd(int[] array) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int num : array) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        result.put("even", even);
        result.put("odd", odd);

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 1023 };
        HashMap<String, ArrayList<Integer>> separated = separateEvenOdd(array);
        System.out.println("Even: " + separated.get("even")); // [2, 4, 6, 8]
        System.out.println("Odd: " + separated.get("odd")); // [1, 3, 5, 7, 9]
    }
}
