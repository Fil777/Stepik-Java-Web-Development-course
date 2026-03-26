package ru.ksergey.dip.ex01;

import java.util.List;

public class SearchByLastName {
    private ListStorage storage;

    public SearchByLastName(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getLastName().contains("_")) {
                System.out.println(p.getFirstName().substring(0, 4) + "...");
            }
        }
        System.out.println();
    }
}
