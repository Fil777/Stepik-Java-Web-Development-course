package stepik.contactsApp.dao.database.testdatafaker;

import stepik.contactsApp.model.entity.ContactOwner;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import stepik.contactsApp.model.enums.AppRole;
import stepik.contactsApp.common.utils.authentification.UserAuthentification;

public class ContactOwnersInitiator {
    public static ArrayList<ContactOwner> generate() {
        int counter = (new Random()).nextInt(10) + 1;
        ArrayList<ContactOwner> owners = new ArrayList<>();
        // сразу добавляем типа админа
        owners.add(new ContactOwner(
                "",
                "admin",
                "admin",
                "administrator",
                "admin@world.com",
                "Admin of the world",
                AppRole.ADMIN
        ));
        // эмулируем владельцев контактов из faker
        Faker faker = new Faker(Locale.of("ru"));
        for (int i = 1; i <= counter; i++) {
            ContactOwner owner = new ContactOwner();
            owner.setFullName(faker.name().fullName());
            owner.setUsername(UserAuthentification.getNewUserName(owner.getFullName()));
            owner.setPassword(UserAuthentification.getNewUserPassword());
            owner.setDescription(faker.lorem().sentence());
            owner.setEmail(UserAuthentification.getNewUserEmail(owner.getFullName()));
            // контакт - в список
            owners.add(owner);
        }
        return owners;
    }



}
