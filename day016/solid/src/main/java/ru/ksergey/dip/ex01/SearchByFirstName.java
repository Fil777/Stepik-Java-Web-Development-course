package ru.ksergey.dip.ex01;

import java.util.List;

public class SearchByFirstName {
    private ListStorage storage;

    public SearchByFirstName(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getFirstName().contains("Name_3")) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }
        System.out.println();
    }
}
