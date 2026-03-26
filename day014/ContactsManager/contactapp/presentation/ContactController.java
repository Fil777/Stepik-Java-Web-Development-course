package contactapp.presentation;

import java.util.ArrayList;

import contactapp.business.model.Contact;
import contactapp.business.service.ContactService;
import contactapp.dto.ContactDto;

public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    public ArrayList<Contact> getAll() {
        return contactService.getAllContacts();
    }

    public Contact getById(int id) {
        return contactService.getContactById(id);
    }

    public Contact create(String name, String email) {
        ContactDto contactCreateDto = new ContactDto(name, email);
        return contactService.createContact(contactCreateDto);
    }

    public boolean update(int id, String name, String email) {
        ContactDto contactUpdateDto = new ContactDto(name, email);
        return contactService.updateContact(contactUpdateDto, id);
    }

    public boolean remove(int id) {
        return contactService.removeContact(id);
    }

    public boolean remove(String name, String email) {
        ContactDto contactDto = new ContactDto(name, email);
        return contactService.removeContact(contactDto);
    }

    public boolean remove(int id, String name, String email) {
        Contact contact = new Contact(id, name, email);
        return contactService.removeContact(contact);
    }
}
