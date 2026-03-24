import init.DataInitializer;
import manager.DataManager;
import model.Person;
import printer.ConsoleDataPrinter;
import printer.DataPrinter;
import repository.ListRepository;
import repository.PersonRepository;

public class Main {
    public static void main(String[] args) {
        // PersonRepository personRepository = new ArrayBasedPersonRepository(10);
        PersonRepository personRepository = new ListRepository();
        DataPrinter<Person> dataPrinter = new ConsoleDataPrinter();

        DataManager dataManager = new DataManager(personRepository, dataPrinter);
        DataInitializer initializer = new DataInitializer(dataManager);

        initializer.populate(1);

        dataManager.displayAllPerson();
    }
}
