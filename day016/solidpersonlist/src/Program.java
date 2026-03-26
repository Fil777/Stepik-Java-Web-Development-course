import printer.ConsoleListDataPrinter;
import repository.ListBasedPersonRepository;
import ui.UserInteface;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ListBasedPersonRepository personRepository = new ListBasedPersonRepository();
        ConsoleListDataPrinter dataPrinter = new ConsoleListDataPrinter();
        Scanner scanner = new Scanner(System.in);

        UserInteface userInteface = new UserInteface();
        userInteface.start(scanner, dataPrinter, personRepository);

    }

}