import contactapp.business.model.Contact;
import contactapp.business.service.ContactService;
import contactapp.business.service.ContactServiceImpl;
import contactapp.dao.InMemoryStorage;
import contactapp.dao.Storage;
import contactapp.infrastructure.Printer;
import contactapp.presentation.ContactController;

public class Main {
    public static void main(String[] args) {
        Storage storage = new InMemoryStorage();
        ContactService contactService = new ContactServiceImpl(storage);
        ContactController controller = new ContactController(contactService);
        Printer printer = new Printer();

        Contact contact = controller.create("Имя", "q@mai.re");
        System.out.println(printer.print(contact));

        boolean flag = controller.update(1, "Новое имя", "i@ksergey.ru");
        System.out.println(flag);

        Contact getContact = controller.getById(1);
        System.out.println(printer.print(getContact));
        System.out.println("--");
        System.out.println(printer.print(controller.getAll()));

        // flag = controller.remove(1);
        // flag = controller.remove("Новое имя", "i@ksergey.ru");
        flag = controller.remove(1, "Новое имя", "i@ksergey.ru");
        System.out.println(flag);
        flag = controller.remove(1, "Новое имя", "i@ksergey.ru");
        System.out.println(flag);
        System.out.println("+++");
        System.out.println(printer.print(controller.getAll()));
    }
}
