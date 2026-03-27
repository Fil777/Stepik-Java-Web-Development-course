package repository;

import model.Person;

import java.util.ArrayList;
import java.util.Comparator;

public interface PersonRepository extends Repository<Person> {
    int getSize();
    int add(Person person);
    void add(Person[] people);
    Person findById(int id);
    int updateById(int id, Person updatedPerson);
    int removeById(int id);
    void clear();
    ArrayList<Person> getAll();
    Person get(int index);
    void sort(Comparator<Person> comparator);
    int maxId();
}
