package repository;

import java.util.Comparator;

public interface Repository <T> {
    int getSize();
    int add(T person);
    void add(T[] people);
    T findById(int id);
    int updateById(int id, T updatedPerson);
    int removeById(int id);
    void clear();
    T[] getAll();
    void sort(Comparator<T> comparator);
}
