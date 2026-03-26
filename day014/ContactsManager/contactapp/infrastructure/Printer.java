package contactapp.infrastructure;

import java.util.ArrayList;

import contactapp.business.model.Contact;

public class Printer {
    public String print(Contact contact) {
        return String.format("id: %d, name: %s, email: %s",
                contact.getId(),
                contact.getName(),
                contact.getEmail());
    }

    public String print(ArrayList<Contact> contacts) {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(String.format("%s\n", print(contact)));
        }
        return sb.toString();
    }
}
