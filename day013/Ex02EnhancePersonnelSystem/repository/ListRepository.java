package repository;

import java.util.ArrayList;

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
        storage.add(person.clone());
    }

    @Override
    public void add(Person[] people) {
        for (Person person : people) {
            add(person);
        }
    }

    @Override
    public Person findById(int id) {
        for (Person person : storage) {
            if (person.getId() == id) {
                return person.clone();
            }
        }

        return new EmptyPerson();
    }

    @Override
    public ArrayList<Person> getAllPersons() {
        ArrayList<Person> temp = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            temp.add(storage.get(i).clone());
        }
        return temp;
    }
}
