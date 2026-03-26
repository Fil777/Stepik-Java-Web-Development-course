package contactapp.utils;

import java.util.ArrayList;

import contactapp.business.model.Contact;

public class Utils {
    public static ArrayList<Contact> copyArrayList(ArrayList<Contact> list) {
        ArrayList<Contact> temp = new ArrayList<>();

        for (Contact contact : list) {
            temp.add(copyContact(contact));
        }
        return temp;
    }

    public static Contact copyContact(Contact contact) {
        return new Contact(contact.getId(), contact.getName(), contact.getEmail());
    }
}
