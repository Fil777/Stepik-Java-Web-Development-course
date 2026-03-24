package core;

import java.util.Comparator;

public class ArrayBasedPersonRepository implements PersonRepository {
    private final Person[] people;
    private int size;

    public ArrayBasedPersonRepository(int capacity){
        this.people = new Person[capacity];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void add(Person person){
        if (size < people.length){
            people[size] = person;
            size++;
        } else {
            throw new RuntimeException("Repository is full!");
        }
    }

    public void add(Person[] people){
        for (Person person : people) {
            add(person);
        }
    }

    public Person findById(int id) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                return person;
            }
        }
        return new EmptyPerson();
    }

    public void removeById(int id) {
        for (int i = 0; i < size; i++) {
            if (people[i].getId() == id) {
                Person removedPerson = people[i];
                people[i] = people[size - 1];
                size--;
                return;
            }
        }
    }

    public Person[] getAll() {
        Person[] result = new Person[size];
        for (int i = 0; i < size; i++) {
            result[i] = people[i];
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            people[i] = null;
        }
        size = 0;
    }

    public void updateById(int id, Person updatedPerson) {
        for (int i = 0; i < size; i++) {
            if (people[i].getId() == id) {
                people[i] = updatedPerson;
                return;
            }
        }
        throw new RuntimeException("Person not found with id: " + id);
    }

    public void sort(Comparator<Person> comparator){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(people[j], people[j + 1]) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }
}
