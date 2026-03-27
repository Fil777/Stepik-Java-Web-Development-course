package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DayTime current = DayTime.EVENING;
        System.out.println(current.getMessage()); // Добрый вечер

        System.out.println(current.name());
        System.out.println(current.toString());
        System.out.println(current.ordinal());

        System.out.println(current.toString() == current.name());


        PersonType pt = PersonType.STUDENT;
        System.out.println(pt.name());
        System.out.println(pt.meaning());
        System.out.println(pt.ordinal());
        System.out.println(pt.toString());
        System.out.println(pt);

        ArrayList<Person> list = new ArrayList<>(){{
                add (new Person(888, "vaska"));
                add (new Person(111, "alka"));
                add (new Person(555, "borka"));
        }};

        System.out.println(list);
        System.out.println(maxId(list));
    }

    public static int maxId(ArrayList<Person> people) {
        Comparator<Person> comparator = Comparator.comparingInt(person -> person.getId());
        return people.stream().max(comparator).get().getId();
    }


}