package repository;

import java.util.ArrayList;
import java.util.Arrays;

import model.EmptyPerson;
import model.Person;

public class ListRepository implements PersonRepository {
    private ArrayList<Person> storage;

    public ListRepository() {
        this.storage = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    public void add(Person person) {
        storage.add(person);
    }

    @Override
    public void add(Person[] people) {
        storage.addAll(Arrays.asList(people));
    }

    @Override
    public Person findById(int id) {
        if (id < 0 || id >= getSize()) {
            return new EmptyPerson();
        }
        return storage.get(id);
    }
}
