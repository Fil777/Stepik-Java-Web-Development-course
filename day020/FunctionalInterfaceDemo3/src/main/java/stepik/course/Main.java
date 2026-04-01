package stepik.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> sqrt = (n) -> n * n;
        System.out.println(sqrt.apply(3));

        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        int count = 10;

        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(10));
        }
        System.out.println(numbers);

        // заменяем то что ниже на более крутой вариант
//        ArrayList<Integer> numbersSqrt = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            numbersSqrt.add(map(numbers.get(i), (n) -> n * n * n));
//        }
        // это улучшенный вариант получения списка
//        ArrayList<Integer> numbersSqrt = numbers
//            .stream()
//            .map(n -> n * n)
//            .collect(Collectors.toCollection(ArrayList::new));
        // улучшаем стрим дальше
        List<Integer> numbersSqrt = numbers
                .stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(numbersSqrt);

        // теперь получаем новым способом чётные числа
//        ArrayList<Integer> numbersEven = process(numbers, (n) -> n % 2 == 0);
        List<Integer> numbersEven = numbers
                .stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(numbersEven);

        printList(numbersEven, n -> System.out.printf("%d ", n));
        System.out.println();
        printList(numbersEven, System.out::println);

        numbersEven.stream().forEach(n -> System.out.printf("%d ", n));
        System.out.println();

    }

    // не нужно при использовании stream
//    static int map (int number, Function<Integer, Integer> op){
//        return op.apply(number);
//    }

    // не нужно при использовании stream
//    static ArrayList<Integer> process (ArrayList<Integer> intArray, Predicate<Integer> op){
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int num : intArray){
//            if (op.test(num)){
//                result.add(num);
//            }
//        }
//        return result;
//    }

    static void printList(List<Integer> array, Consumer<Integer> act){
        for (int element : array){
            act.accept(element);
        }
    }

}