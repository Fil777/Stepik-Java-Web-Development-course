package core;

import java.util.Comparator;

public interface Repository <T> {
    int getSize();
    void add(T person);
    void add(T[] people);
    T findById(int id);
    void updateById(int id, T updatedPerson);
    void removeById(int id);
    void clear();
    T[] getAll();
    void sort(Comparator<T> comparator);
}
