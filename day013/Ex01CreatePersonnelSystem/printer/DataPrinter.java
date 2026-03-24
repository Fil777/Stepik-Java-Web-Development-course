package printer;

import repository.PersonRepository;

public interface DataPrinter<T> {
    void displayAll(PersonRepository repository);
}
