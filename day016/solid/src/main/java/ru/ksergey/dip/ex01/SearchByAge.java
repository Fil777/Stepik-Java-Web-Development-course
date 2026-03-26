package ru.ksergey.dip.ex01;

import java.util.List;

public class SearchByAge {
    private ListStorage storage;

    public SearchByAge(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getAge() > 45) {
                System.out.println(p.getFirstName() + " " + p.getAge());
            }
        }
        System.out.println();
    }
}
