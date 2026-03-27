import printer.ConsoleListDataPrinter;
import repository.ListBasedPersonRepository;
import ui.UserInteraction;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) {
        final ListBasedPersonRepository personRepository = new ListBasedPersonRepository();
        ConsoleListDataPrinter dataPrinter = new ConsoleListDataPrinter();
        final Scanner scanner = new Scanner(System.in);
        final Logger logger = Logger.getLogger(Class.class.getName());

        logger.setLevel(Level.INFO);

        UserInteraction userInteface = new UserInteraction();
        userInteface.start(scanner, dataPrinter, personRepository, logger);

    }

}