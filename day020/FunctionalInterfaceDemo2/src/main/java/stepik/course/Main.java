package stepik.course;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> sqrt = (n) -> n * n;
        System.out.println(sqrt.apply(3));

        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        int count = 10;

        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.println(numbers);

        ArrayList<Integer> numbersSqrt = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbersSqrt.add(map(numbers.get(i), (n) -> n * n * n));
        }
        System.out.println(numbersSqrt);

        ArrayList<Integer> numbersEven = process(numbers, (n) -> n % 2 == 0);
        System.out.println(numbersEven);

        printList(numbersEven, n -> System.out.print(n + " "));
        System.out.println();
        printList(numbersEven, System.out::println);


    }

    // такой интерфейс уже есть, называется Function
    // поэтому это можно убрать
//    @FunctionalInterface
//    interface NumberFunction<R, T> {
//        R apply(T x);
//    }

    // такой интерфейс уже есть, называется Predicate
    // поэтому это можно убрать
//    @FunctionalInterface
//    interface NumberPredicate<T> {
//        boolean test(T x);
//    }

    static int map (int number, Function<Integer, Integer> op){
        return op.apply(number);
    }

    static ArrayList<Integer> process (ArrayList<Integer> intArray, Predicate<Integer> op){
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : intArray){
            if (op.test(num)){
                result.add(num);
            }
        }
        return result;
    }

    static void printList(ArrayList<Integer> arrayList, Consumer<Integer> act){
        for (int element : arrayList){
            act.accept(element);
        }
    }

}