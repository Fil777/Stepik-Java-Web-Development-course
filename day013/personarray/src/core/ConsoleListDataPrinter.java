package core;

public class ConsoleListDataPrinter implements DataPrinter<ListBasedPersonRepository>{
    @Override
    public void displayAll(ListBasedPersonRepository repository) {
        PersonComparator comparator = new PersonComparator();
        repository.sort(comparator);
        Terminal.writeLine("Общий список:");
        for (Person person : repository.getAll()) {
            Terminal.writeLine(person.toString());
        }
        Terminal.writeLine("---");
    }
}

