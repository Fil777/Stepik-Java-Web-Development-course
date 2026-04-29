package stepik.contactsApp.dao.datainitialization;

import com.github.javafaker.Faker;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class ContactDetailsInitiator {
    public static ArrayList<ContactDetail> generate(Contact contact) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int detailCounter = 1;
        //int detailCounter = (new Random()).nextInt(10) + 1;
        ArrayList<ContactDetail> details = new ArrayList<>();
        Faker faker = new Faker(Locale.of("ru"));
        for (int i = 1; i <= detailCounter; i++){
            ContactDetail contactDetail = new ContactDetail(
                    null,
                    sdf.format(faker.date().birthday(1,5)),
                    faker.company().name(),
                    faker.lorem().sentence(),
                    faker.aviation().airport(),
                    contact
            );
            details.add(contactDetail);
        }
        return details;
    }
}
