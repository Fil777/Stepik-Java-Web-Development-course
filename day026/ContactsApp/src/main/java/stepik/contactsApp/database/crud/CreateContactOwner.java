package stepik.contactsApp.database.crud;

import stepik.contactsApp.database.Database;
import stepik.contactsApp.model.entity.ContactOwner;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CreateContactOwner {
    public static void operation(Database database, ContactOwner owner) {

        if (!database.isActive()) {
            throw new RuntimeException("БД не открыто. Операция невозможна.");
        }

        PreparedStatement preparedStatement;

        try {
            preparedStatement = database.getConnect().prepareStatement(
                    "INSERT INTO contact_owners "
                            + "(id,name,username,description,email,password,role) "
                            + "values(?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, owner.getFullName());
            preparedStatement.setString(3, owner.getUsername());
            preparedStatement.setString(4, owner.getDescription());
            preparedStatement.setString(5, owner.getEmail());
            preparedStatement.setString(6, owner.getPassword());
            preparedStatement.setString(7, owner.getRole().name());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
