package stepik.ContactsApp.service.contacts;

import stepik.ContactsApp.model.dto.CreateContactDTO;
import stepik.ContactsApp.model.dto.UpdateContactDTO;
import stepik.ContactsApp.model.entity.Contact;

import java.util.List;

public interface ContactServiceInterface {
    List<Contact> getAllContacts();
    Contact getContact(int id);
    Contact createContact(CreateContactDTO dto);
    Contact updateContact(UpdateContactDTO dto);
    boolean deleteContact(int id);

}
