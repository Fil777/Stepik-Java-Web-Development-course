package repository;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ListBasedPersonRepository implements PersonRepository {
    private ArrayList<Person> people;

    public ListBasedPersonRepository() {
        this.people = new ArrayList<>();
    }

    public int getSize() {
        return people.size();
    }

    public int add(Person person) {
        people.add(person);
        return person.getId();
    }

    public void add(Person[] people) {
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
        return null;
    }

    public int removeById(int id) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                people.remove(person);
                return id;
            }
        }
        return -1;
    }

    public ArrayList<Person> getAll() {
        ArrayList<Person> result = this.people;
        return result;
    }

    public Person get(int index) {
        if (index < 0 || index >= people.size()) {
            return null;
        }
        return people.get(index);
    }

    public void clear() {
        people.clear();
    }

    public int updateById(int id, Person updatedPerson) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                person = updatedPerson;
                return id;
            }
        }
        return -1;
    }

    public void sort(Comparator<Person> comparator) {
        people.sort(comparator);
    }

    public int maxId(){
        Comparator<Person> comparator = Comparator.comparingInt(person -> person.getId());
        return people.stream().max(comparator).get().getId();
    }

}

