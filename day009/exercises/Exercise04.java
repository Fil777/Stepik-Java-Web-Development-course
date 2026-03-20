package exercises;

import java.util.ArrayList;

public class Exercise04 {
    public static ArrayList<Integer> getEvenNumbers(int n) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (int i = 2; i <= n; i += 2) {
            evenNumbers.add(i);
        }

        return evenNumbers;
    }

    public static void main(String[] args) {
        System.out.println(getEvenNumbers(5)); // [2, 4]
        System.out.println(getEvenNumbers(10)); // [2, 4, 6, 8, 10]
    }
}
