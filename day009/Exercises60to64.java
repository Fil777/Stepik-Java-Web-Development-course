import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Exercises60to64 {
    public static void main(String[] args) {
        // 60
        System.out.println(getGradeDescription(3));

        // 61
        Map<String, Double> basket = new HashMap<>() {
            {
                put("item1", 25000.00);
                put("item2", 150000.00);
                put("item3", 35000.00);
            }
        };
        System.out.println(basket.toString());
        System.out.println(calculateBonusPoints(basket));

        // 62
        System.out.println(getTriangleType(5.0, 10.0, 5.0));

        // 63
        System.out.println(getEvenNumbers(10).toString());

        // 64
        System.out.println(factorial(-10));

    }

    static String getGradeDescription(int rate) {
        switch (rate) {
            case 5:
                return "(5)отлично";
            case 4:
                return "(4)хорошо";
            case 3:
                return "(3)удовлетворительно";
            case 2:
                return "(2)неудовлетворительно";
            case 1:
                return "(1)неудовлетворительно";
            default:
                return "некорректная оценка";
        }
    }

    static int calculateBonusPoints(Map<String, Double> basket) {
        double totalPrice = 0.0;
        for (Double value : basket.values()) {
            totalPrice += value;
        }
        int bonusPoints = (int) totalPrice / 100;
        if (totalPrice > 100000.0) {
            bonusPoints += 1000;
        }
        return bonusPoints;
    }

    static String getTriangleType1(double a, double b, double c) {
        ArrayList<Double> sides = new ArrayList<>(Arrays.asList(a, b, c));
        Collections.sort(sides);
        if (sides.get(0) + sides.get(1) <= sides.get(2)) {
            return "не треугольник";
        } else if (sides.get(0).equals(sides.get(1)) && sides.get(1).equals(sides.get(2))) {
            return "равносторонний";
        } else if (sides.get(0).equals(sides.get(1)) || sides.get(1).equals(sides.get(2))) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }
    }

    static String getTriangleType(double a, double b, double c) {
        if (a + b <= c || b + c <= a || a + c <= b) {
            return "не треугольник";
        } else if (a == b && b == c) {
            return "равносторонний";
        } else if (a == b || b == c || a == c) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }
    }

    static ArrayList<Integer> getEvenNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n < 2) {
            return null;
        }
        for (int i = 2; i <= n; i += 2) {
            list.add(i);
        }
        return list;
    }

    static long factorial(int n) {
        if (n < 0)
            return -1;
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

}
