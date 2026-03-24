package repository;

import model.EmptyPerson;
import model.Person;

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

    public int add(Person person){
        people.add(person);
        return person.getId();
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

    public int removeById(int id) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                people.remove(person);
                return id;
            }
        }
        return -1;
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

    public int updateById(int id, Person updatedPerson) {
        for (Person person : this.people) {
            if (person != null && person.getId() == id) {
                person = updatedPerson;
                return id;
            }
        }
        return -1;
    }

    public void sort(Comparator<Person> comparator){
        people.sort(comparator);
    }

}

