package repository;

public interface Repository<T> {
    int getSize();

    void add(T person);

    void add(T[] people);

    T findById(int id);
}
