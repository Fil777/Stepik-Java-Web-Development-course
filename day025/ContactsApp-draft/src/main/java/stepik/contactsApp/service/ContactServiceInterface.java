package stepik.contactsApp.service;

import stepik.contactsApp.model.dto.CreateContactDTO;
import stepik.contactsApp.model.dto.UpdateContactDTO;
import stepik.contactsApp.model.entity.Contact;

import java.util.List;

public interface ContactServiceInterface {
    List<Contact> getAllContacts();
    Contact getContact(int id);
    Contact createContact(CreateContactDTO dto);
    Contact updateContact(UpdateContactDTO dto);
    boolean deleteContact(int id);

}
