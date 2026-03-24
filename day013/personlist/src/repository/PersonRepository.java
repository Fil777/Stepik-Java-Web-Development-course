package repository;

import model.Person;

import java.util.Comparator;

public interface PersonRepository extends Repository<Person> {
    int getSize();
    int add(Person person);
    void add(Person[] people);
    Person findById(int id);
    int updateById(int id, Person updatedPerson);
    int removeById(int id);
    void clear();
    Person[] getAll();
    void sort(Comparator<Person> comparator);
}
