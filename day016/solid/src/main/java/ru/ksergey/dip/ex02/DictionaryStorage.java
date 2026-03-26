package ru.ksergey.dip.ex02;

import java.util.HashMap;
import java.util.Map;

public class DictionaryStorage {
    private Map<String, Person> storage;

    public DictionaryStorage() {
        storage = new HashMap<>();
        add("SingleResponsibility", new Person("FirstName_1", "LastName_1", 55));
        add("OpenClosed", new Person("FirstName_2", "LastName_2", 33));
        add("LiskovSubstitution", new Person("FirstName_3", "LastName_3", 80));
        add("InterfaceSegregation", new Person("FirstName_4", "LastName_4", 67));
        add("DependencyInversion", new Person("FirstName_5", "LastName_5", 20));
    }

    public Map<String, Person> getPersons() {
        return this.storage;
    }

    public void add(String key, Person p) {
        storage.put(key, p);
    }
}
