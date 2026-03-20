package exercises;

import java.util.HashMap;

public class Exercise20 {
    public static HashMap<String, Integer> countNumberTypes(int[] array) {
        HashMap<String, Integer> result = new HashMap<>();

        int positive = 0, negative = 0, zero = 0;
        for (int num : array) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        result.put("positive", positive);
        result.put("negative", negative);
        result.put("zero", zero);

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, -2, 0, 3, -4, 0, 5 };
        HashMap<String, Integer> counts = countNumberTypes(array);
        System.out.println("Больше нуля: " + counts.get("positive")); // 3
        System.out.println("Меньше нуля: " + counts.get("negative")); // 2
        System.out.println("Равны нулю: " + counts.get("zero")); // 2
    }
}
