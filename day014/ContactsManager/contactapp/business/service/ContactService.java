package contactapp.business.service;

import java.util.ArrayList;

import contactapp.business.model.Contact;
import contactapp.dto.ContactDto;

public interface ContactService {
    ArrayList<Contact> getAllContacts();

    Contact getContactById(int id);

    Contact createContact(ContactDto contactDto);

    boolean updateContact(ContactDto contactDto, int id);

    boolean removeContact(int id);

    boolean removeContact(Contact contact);

    boolean removeContact(ContactDto contactDto);
}
