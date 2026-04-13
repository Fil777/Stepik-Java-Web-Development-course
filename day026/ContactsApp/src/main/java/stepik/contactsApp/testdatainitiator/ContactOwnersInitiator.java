package stepik.contactsApp.testdatainitiator;

import stepik.contactsApp.model.entity.ContactOwner;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;
import stepik.contactsApp.service.authentification.UserAuthentification;

public class ContactOwnersInitiator {
    public static ArrayList<ContactOwner> generate() {
        int counter = 10;
        ArrayList<ContactOwner> owners = new ArrayList<>();

        // эмулируем владельцев контактов из faker
        Faker faker = new Faker(Locale.of("ru"));
        for (int i = 1; i < counter; i++) {
            ContactOwner owner = new ContactOwner();
            owner.setId(UserAuthentification.getNewUserId());
            owner.setId(UserAuthentification.getNewUserId());
            owner.setFullName(faker.name().fullName());
            owner.setUsername(UserAuthentification.getNewUserName(owner.getFullName()));
            owner.setPassword(UserAuthentification.getNewUserPassword());
            owner.setDescription(faker.lorem().sentence());
            owner.setEmail(UserAuthentification.getNewUserEmail(owner.getFullName()));
            owner.setRole(UserAuthentification.getNewUserRole(owner.getUsername()));
            owner.setDescription(faker.lorem().sentence());
            // контакт - в список
            owners.add(owner);
        }
        return owners;
    }



}
