package core;

public class ConsoleArrayDataPrinter implements DataPrinter<ArrayBasedPersonRepository> {
    @Override
    public void displayAll(ArrayBasedPersonRepository repository) {
        PersonComparator comparator = new PersonComparator();
        repository.sort(comparator);
        Terminal.writeLine("Общий список:");
        for (Person person : repository.getAll()) {
            Terminal.writeLine(person.toString());
        }
        Terminal.writeLine("---");
    }

}
