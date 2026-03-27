package repository;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;

public interface Repository <T> {
    int getSize();
    int add(T element);
    void add(T[] elements);
    T findById(int id);
    int updateById(int id, T updatedElement);
    int removeById(int id);
    void clear();
    ArrayList<T> getAll();
    T get(int index);
    void sort(Comparator<T> comparator);
    int maxId();
}
