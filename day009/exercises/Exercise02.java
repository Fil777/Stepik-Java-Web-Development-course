package exercises;

import java.util.HashMap;

public class Exercise02 {
    public static int calculateBonusPoints(HashMap<String, Double> purchases) {
        double totalSum = 0;

        for (Double price : purchases.values()) {
            totalSum += price;
        }

        int bonusPoints = (int) (totalSum / 100);
        if (totalSum > 100000) {
            bonusPoints += 1000;
        }

        return bonusPoints;
    }

    public static void main(String[] args) {
        HashMap<String, Double> purchases1 = new HashMap<>();
        purchases1.put("item1", 50000.0);
        purchases1.put("item2", 60000.0);
        System.out.println("Бонусные баллы: " + calculateBonusPoints(purchases1)); // 2100

        HashMap<String, Double> purchases2 = new HashMap<>();
        purchases2.put("item1", 30000.0);
        System.out.println("Бонусные баллы: " + calculateBonusPoints(purchases2)); // 300
    }
}
