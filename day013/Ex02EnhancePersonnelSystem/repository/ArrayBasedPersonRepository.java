package repository;

import java.util.ArrayList;

import model.EmptyPerson;
import model.Person;

public class ArrayBasedPersonRepository implements PersonRepository {
    private Person[] storage;
    private int count;
    private int currentIndex;

    public ArrayBasedPersonRepository(int count) {
        this.count = count;
        this.storage = new Person[count];
        this.currentIndex = 0;
    }

    @Override
    public int getSize() {
        return currentIndex;
    }

    @Override
    public void add(Person person) {
        if (currentIndex >= count) {
            return;
        }
        storage[currentIndex] = person.clone();
        currentIndex++;
    }

    @Override
    public void add(Person[] people) {
        for (Person person : people) {
            this.add(person);
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
        for (int i = 0; i < currentIndex; i++) {
            temp.add(storage[i].clone());
        }
        return temp;
    }
}
