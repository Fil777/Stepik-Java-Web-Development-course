package stepik.contactsApp.database.crud;

import stepik.contactsApp.database.Database;
import stepik.contactsApp.model.entity.Contact;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateContact {
    public static void operation(Database database, Contact contact) {

        if (!database.isActive()) {
            throw new RuntimeException("БД не открыто. Операция невозможна.");
        }

        try {
            PreparedStatement preparedStatement;

            preparedStatement = database.getConnect().prepareStatement(
                    "INSERT INTO contacts "
                            + "(first_name, last_name, sex, birthdate, telephone, email) "
                            + "values( ?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)");

            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getSex());
            preparedStatement.setString(4, contact.getBirthDate());
            preparedStatement.setString(5, contact.getTelephone());
            preparedStatement.setString(6, contact.getEmail());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
