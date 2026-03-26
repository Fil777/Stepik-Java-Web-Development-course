package contactapp.dao;

import java.util.ArrayList;

import contactapp.business.model.Contact;
import contactapp.dto.ContactDto;
import contactapp.utils.Utils;

public class InMemoryStorage implements Storage {
    private ArrayList<Contact> contacts;

    public InMemoryStorage() {
        contacts = new ArrayList<>();
    }

    @Override
    public ArrayList<Contact> findAll() {
        return Utils.copyArrayList(contacts);
    }

    @Override
    public Contact findById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return Utils.copyContact(contact);
            }
        }
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        for (Contact current : contacts) {
            if (current.getId() == contact.getId()) {
                return null;
            }
        }

        contacts.add(Utils.copyContact(contact));
        return Utils.copyContact(contact);
    }

    @Override
    public boolean updateContact(ContactDto contactDto, int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(contactDto.getName());
                contact.setEmail(contactDto.getEmail());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Contact contact) {
        return contacts.remove(contact); // TODO
    }

    @Override
    public boolean delete(ContactDto contactDto) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(contactDto.getName())
                    && contact.getEmail().equals(contactDto.getEmail())) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }
}
