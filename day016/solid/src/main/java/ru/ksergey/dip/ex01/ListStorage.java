package ru.ksergey.dip.ex01;

import java.util.ArrayList;
import java.util.List;

public class ListStorage {
    private List<Person> storage;

    public ListStorage() {
        storage = new ArrayList<>();
        add(new Person() {
            {
                setLastName("LastName_1");
                setFirstName("FirstName_1");
                setAge(55);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_2");
                setFirstName("FirstName_2");
                setAge(33);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_3");
                setFirstName("FirstName_3");
                setAge(80);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_4");
                setFirstName("FirstName_4");
                setAge(67);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_5");
                setFirstName("FirstName_5");
                setAge(20);
            }
        });
    }

    public List<Person> getPersons() {
        return this.storage;
    }

    public void add(Person p) {
        storage.add(p);
    }
}
