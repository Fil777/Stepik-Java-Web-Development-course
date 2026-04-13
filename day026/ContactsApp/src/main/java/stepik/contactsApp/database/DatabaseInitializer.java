package stepik.contactsApp.database;

import org.springframework.stereotype.Component;
import stepik.contactsApp.database.crud.CreateContact;
import stepik.contactsApp.database.crud.CreateContactOwner;
import stepik.contactsApp.database.crud.ReadContact;
import stepik.contactsApp.testdatainitiator.ContactOwnersInitiator;
import stepik.contactsApp.testdatainitiator.ContactsInitiator;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactOwner;
import stepik.contactsApp.model.enums.AppRole;

import java.util.List;

@Component
public class DatabaseInitializer {
    private final Database database;

    public DatabaseInitializer() {
        this.database = new Database();
    }

    private void createTables() {
        CreateDatabaseObjects.createTables(this.database);
    }

    private void insertData() {

        List<Contact> contacts = ContactsInitiator.generate();
        contacts.add(new Contact(
                0,
                "Валентина",
                "Ёшкина-Кошкина",
                "Ж",
                "2000-11-18",
                "+7(999)888-77-66",
                "valentina.eshkina@mail.ru"
        ));
        contacts.stream().forEach(contact -> {
            CreateContact.operation(this.database, contact);
        });

        List<ContactOwner> contactOwners = ContactOwnersInitiator.generate();
        contactOwners.add(new ContactOwner(
                "",
                "admin",
                "admin",
                "administrator",
                "admin@world.com",
                "Admin of the world",
                AppRole.ADMIN
        ));
        contactOwners.stream().forEach(contactOwner -> {
            CreateContactOwner.operation(this.database, contactOwner);
        });

        this.database.commit();
    }

    public void init() {
        this.database.open();
        boolean checkOwners = this.database.tableExists("contact_owners");
        if (!checkOwners) {
            createTables();
            insertData();
        }
        //Contact temp = ReadContact.operation(this.database, 104);
        this.database.close();
    }
}

