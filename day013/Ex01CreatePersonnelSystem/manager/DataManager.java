package manager;

import model.Person;
import printer.DataPrinter;
import repository.PersonRepository;

public class DataManager {
    private PersonRepository repository;
    private DataPrinter<Person> printer;

    public DataManager(PersonRepository repository, DataPrinter<Person> printer) {
        this.repository = repository;
        this.printer = printer;
    }

    // addPerson(new Student(...))
    // addPerson(new Person[]{new Student(...), new Stuff(...)})
    // addPerson(new Student(...), new Stuff(...))
    public void addPerson(Person... persons) {
        repository.add(persons);
    }

    public Person findById(int id) {
        return repository.findById(id);
    }

    public void displayAllPerson() {
        printer.displayAll(repository);
    }

    public int getRepositorySize() {
        return repository.getSize();
    }
}
