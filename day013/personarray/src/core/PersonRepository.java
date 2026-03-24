package core;

import java.util.Comparator;

public interface PersonRepository extends Repository<Person> {
    int getSize();
    void add(Person person);
    void add(Person[] people);
    Person findById(int id);
    void updateById(int id, Person updatedPerson);
    void removeById(int id);
    void clear();
    Person[] getAll();
    void sort(Comparator<Person> comparator);
}
