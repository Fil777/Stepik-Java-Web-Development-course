package exercises;

import java.util.ArrayList;

public class Exercise09 {
    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static void main(String[] args) {
        System.out.println(getDivisors(12)); // [1, 2, 3, 4, 6, 12]
        System.out.println(getDivisors(17)); // [1, 17]
    }
}
