package core;

import java.util.ArrayList;
import java.util.Comparator;

public class ListBasedPersonRepository implements PersonRepository {
    private ArrayList<Person> people;

    public ListBasedPersonRepository(){
        this.people = new ArrayList<>();
    }

    public int getSize() {
        return people.size();
    }

    public void add(Person person){
        people.add(person);
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
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                people.remove(person);
            }
        }
    }

    public Person[] getAll() {
        Person[] result = new Person[people.size()];
        for (int i = 0; i < people.size(); i++) {
            result[i] = people.get(i);
        }
        return result;
    }

    public void clear() {
        people.clear();
    }

    public void updateById(int id, Person updatedPerson) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                person = updatedPerson;
            }
        }
    }

    public void sort(Comparator<Person> comparator){
        people.sort(comparator);
    }
}

