package stepik.contactsApp.dao;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import stepik.contactsApp.datainitiator.ContactsInitiator;
import stepik.contactsApp.model.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepository implements ContactRepositoryInterface {

    private final List<Contact> contacts;// = new ArrayList<>();

    private final ModelMapper modelMapper;

    public ContactRepository(ModelMapper modelMapper) {
        this.contacts = ContactsInitiator.generate();
        this.modelMapper = modelMapper;
    }

    public List<Contact> findAll() {
        return new ArrayList<>(contacts);
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() > 0) {
            Optional<Contact> opContact;
            Contact contactInList;
            opContact = findById(contact.getId());
            if (opContact.isPresent()) {
                contactInList = opContact.get();
                contactInList.updateWith(contact);
                return contactInList;
            }
        }
        int newId = contacts.stream()
                .mapToInt(c -> c.getId())
                .max()
                .orElse(0) + 1;
        contact.setId(newId);
        contacts.add(contact);
        return contact;
    }

    @Override
    public boolean deleteById(int id) {
        return contacts.removeIf(contact -> contact.getId() == id);
    }

    @Override
    public Optional<Contact> findById(int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return contacts.stream()
                .filter(contact -> contact.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Optional<Contact> findByPhone(String phone) {
        return contacts.stream()
                .filter(contact -> contact.getTelephone().equalsIgnoreCase(phone))
                .findFirst();
    }

}
