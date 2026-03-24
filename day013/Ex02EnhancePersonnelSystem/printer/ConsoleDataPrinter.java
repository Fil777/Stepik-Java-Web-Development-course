package printer;

import java.util.ArrayList;

import model.Person;
import repository.PersonRepository;

public class ConsoleDataPrinter implements DataPrinter<Person> {

    @Override
    public void displayAll(PersonRepository repository) {
        ArrayList<Person> all = repository.getAllPersons();

        for (Person person : all) {
            System.out.println(person.toString());
        }
    }
}
