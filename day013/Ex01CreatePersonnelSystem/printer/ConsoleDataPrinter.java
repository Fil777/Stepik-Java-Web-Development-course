package printer;

import model.Person;
import repository.PersonRepository;

public class ConsoleDataPrinter implements DataPrinter<Person> {

    @Override
    public void displayAll(PersonRepository repository) {
        int max = repository.getSize();

        for (int i = 0; i < max; i++) {
            System.out.println(repository.findById(i).toString());
        }
    }
}
