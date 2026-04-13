package stepik.contactsApp.database.crud;

import stepik.contactsApp.database.Database;
import stepik.contactsApp.model.entity.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadContact {
    public static Contact operation(Database database, int id) {

        if (!database.isActive()) {
            throw new RuntimeException("БД не открыто. Операция невозможна.");
        }

        try {
            PreparedStatement preparedStatement;

            preparedStatement = database.getConnect().prepareStatement(
                    "SELECT * FROM contacts WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Contact contact = new Contact(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                        );
                return contact;
            }

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
