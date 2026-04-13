package stepik.contactsApp.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import stepik.contactsApp.database.datagenerator.CreateDatabaseObjects;
import stepik.contactsApp.database.datagenerator.InsertDatabaseRecords;
import stepik.contactsApp.database.testdatafaker.ContactOwnersInitiator;
import stepik.contactsApp.database.testdatafaker.ContactsInitiator;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DatabaseInitializer {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void createTables() {
        CreateDatabaseObjects.createTables(this.jdbcTemplate);
    }

    private void insertData() {

        List<Contact> contacts = ContactsInitiator.generate();

        InsertDatabaseRecords.insertContacts(this.jdbcTemplate, contacts);

        List<ContactOwner> contactOwners = ContactOwnersInitiator.generate();

        InsertDatabaseRecords.insertContactOwners(this.jdbcTemplate, contactOwners);

    }

    public void init() {
        createTables();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "***   Объекты созданы.");
        insertData();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "***   Данные загружены.");
    }
}
