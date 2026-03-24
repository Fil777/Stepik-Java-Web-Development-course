package repository;

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
        storage[currentIndex] = person;
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
        if (id < 0 || id >= currentIndex) {
            return new EmptyPerson();
        }

        return storage[id];
    }
}
