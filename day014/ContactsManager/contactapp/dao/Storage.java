package contactapp.dao;

import java.util.ArrayList;

import contactapp.business.model.Contact;
import contactapp.dto.ContactDto;

public interface Storage {
    ArrayList<Contact> findAll();

    Contact findById(int id);

    Contact save(Contact contact);

    boolean updateContact(ContactDto contactDto, int id);

    boolean delete(int id);

    boolean delete(Contact contact);

    boolean delete(ContactDto contactDto);
}
