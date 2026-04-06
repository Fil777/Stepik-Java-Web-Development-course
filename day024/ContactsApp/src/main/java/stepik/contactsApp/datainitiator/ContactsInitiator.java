package stepik.contactsApp.datainitiator;

import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.common.util.transliterator.CyrillicToLatin;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ContactsInitiator {

    public static ArrayList<Contact> generate() {
        int contactsCounter = 20;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Contact> contacts = new ArrayList<>();
        Faker faker = new Faker(Locale.of("ru"));
        // эмулируем контакты из faker
        for (int i = 1; i < contactsCounter; i++) {
            Contact contact = new Contact(
                    i,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.demographic().sex(),
                    sdf.format(faker.date().birthday(18, 68)),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress()
            );
            // русификация ФИО
            updateNamesAsRussian(contact);
            // русификация пола
            updateSexAsRussian(contact);
            // латинизация email
            contact.setEmail(
                    CyrillicToLatin.transliterate(contact.getFirstName()) + "."
                            + CyrillicToLatin.transliterate(contact.getLastName()) + "@mail.ru");
            // контакт - в список
            contacts.add(contact);
        }
        return contacts;
    }

    private static void updateNamesAsRussian(Contact contact) {
        if (contact.getLastName().length() <= 2) return;
        char lastNameEndChar = contact.getLastName().charAt(contact.getLastName().length() - 1);
        char firstNameEndChar = contact.getFirstName().charAt(contact.getFirstName().length() - 1);

        boolean male = firstNameEndChar != 'а' && firstNameEndChar != 'я';
        boolean female = firstNameEndChar == 'а' || firstNameEndChar == 'я'
                            || lastNameEndChar == 'а' || lastNameEndChar == 'я';

        if (female && !male) {
            contact.setSex("Female");
            if (lastNameEndChar != 'а' && lastNameEndChar != 'я') {
                contact.setLastName(contact.getLastName() + "а");
            }
        } else {
            contact.setSex("Male");
            if (lastNameEndChar == 'а') {
                contact.setLastName(contact.getLastName().substring(0, contact.getLastName().length() - 1));
            } else if ((contact.getLastName() + '#').indexOf("ая#") > 0) {
                contact.setLastName(contact.getLastName().substring(0, contact.getLastName().length() - 2));
            }
        }
    }

    private static void updateSexAsRussian(Contact contact) {
        if (contact.getSex().equalsIgnoreCase("Male")) {
            contact.setSex("М");
        } else if (contact.getSex().equalsIgnoreCase("Female")) {
            contact.setSex("Ж");
        } else {
            // Handle other sex values or set a default
            contact.setSex("-");
        }
    }

}
