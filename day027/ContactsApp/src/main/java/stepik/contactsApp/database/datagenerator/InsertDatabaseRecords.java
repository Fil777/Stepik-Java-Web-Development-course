package stepik.contactsApp.database.datagenerator;

import org.springframework.jdbc.core.JdbcTemplate;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.List;

public class InsertDatabaseRecords {
    public static void insertContacts(JdbcTemplate database, List<Contact> contacts) {
        String check = "SELECT COUNT(*) FROM contacts";
        int cnt = database.queryForObject(check, Integer.class);
        if (cnt > 0) {
            return;
        }

        String insert = "INSERT INTO contacts "
                + "(first_name, last_name, sex, birthdate, telephone, email) "
                + "values( ?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

        database.batchUpdate(insert, contacts, 100, (preparedStatement, contact) -> {
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getSex());
            preparedStatement.setString(4, contact.getBirthDate());
            preparedStatement.setString(5, contact.getTelephone());
            preparedStatement.setString(6, contact.getEmail());
        });
    }

    public static void insertContactOwners(JdbcTemplate database, List<ContactOwner> owners) {
        String check = "SELECT COUNT(*) FROM contact_owners";
        int cnt = database.queryForObject(check, Integer.class);
        if (cnt > 0) {
            return;
        }

        String insert = "INSERT INTO contact_owners "
                + "(id,name,username,description,email,password,role) "
                + "values(?,?,?,?,?,?,?)";

        database.batchUpdate(insert, owners, 100, (preparedStatement, owner) -> {
            preparedStatement.setString(1, owner.getId());
            preparedStatement.setString(2, owner.getFullName());
            preparedStatement.setString(3, owner.getUsername());
            preparedStatement.setString(4, owner.getDescription());
            preparedStatement.setString(5, owner.getEmail());
            preparedStatement.setString(6, owner.getPassword());
            preparedStatement.setString(7, owner.getRole().name());

        });
    }

}
