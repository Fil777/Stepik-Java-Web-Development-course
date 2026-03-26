package ru.ksergey.dip.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListStorage implements FindStorage {
    private List<Person> storage;

    public ListStorage() {
        storage = new ArrayList<>();
        add(new Person("FirstName_1", "LastName_1", 55));
        add(new Person("FirstName_2", "LastName_2", 33));
        add(new Person("FirstName_3", "LastName_3", 80));
        add(new Person("FirstName_4", "LastName_4", 67));
        add(new Person("FirstName_5", "LastName_5", 20));
    }

    public List<Person> getPersons() {
        return this.storage;
    }

    public void add(Person p) {
        storage.add(p);
    }

    @Override
    public List<Person> findAll(Predicate<Person> predicate) {
        return storage.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
