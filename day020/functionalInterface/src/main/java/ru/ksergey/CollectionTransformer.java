package ru.ksergey;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionTransformer {
    public static void main(String[] args) {
        Random random = new Random();
        // [1, 2, 3] -> [3, 6, 9] -> [6]

        ArrayList<Integer> numbers = new ArrayList<>();
        int count = 10;
        for (int i = 0; i < count; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);

        List<Integer> res = numbers.stream()
                .map(x -> x * 3)
                .filter(x -> x % 2 == 0)
                .toList();

        System.out.println(res);
    }
}