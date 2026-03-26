package contactapp.business.service;

import java.util.ArrayList;

import contactapp.business.model.Contact;
import contactapp.dao.Storage;
import contactapp.dto.ContactDto;
import contactapp.infrastructure.IdGenerator;

public class ContactServiceImpl implements ContactService {
    private Storage storage;

    public ContactServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return storage.findAll();
    }

    @Override
    public Contact getContactById(int id) {
        return storage.findById(id);
    }

    @Override
    public Contact createContact(ContactDto contactDto) {
        if (contactDto != null) {
            Contact contact = new Contact(IdGenerator.getId());
            String nameDto = contactDto.getName();

            if (nameDto != null && !nameDto.isEmpty()) {
                contact.setName(nameDto);
            }

            String emailDto = contactDto.getEmail();

            if (emailDto != null && !emailDto.isEmpty()) {
                contact.setEmail(emailDto);
            }

            return storage.save(contact);
        }

        return null;
    }

    @Override
    public boolean updateContact(ContactDto contactDto, int id) {
        if (contactDto != null) {
            String nameDto = contactDto.getName();
            String emailDto = contactDto.getEmail();

            if (nameDto != null
                    && !nameDto.isEmpty()
                    && emailDto != null
                    && !emailDto.isEmpty()) {
                return storage.updateContact(contactDto, id);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean removeContact(int id) {
        return storage.delete(id);
    }

    @Override
    public boolean removeContact(Contact contact) {
        return storage.delete(contact);
    }

    @Override
    public boolean removeContact(ContactDto contactDto) {
        return storage.delete(contactDto);
    }
}
