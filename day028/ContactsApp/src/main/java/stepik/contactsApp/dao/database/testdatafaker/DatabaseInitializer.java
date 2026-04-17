package stepik.contactsApp.dao.database.testdatafaker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stepik.contactsApp.dao.JpaContactOwnerRepositoryAdapter;
import stepik.contactsApp.dao.JpaContactRepositoryAdapter;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.List;

@Slf4j
@Component
public class DatabaseInitializer {
    private final JpaContactOwnerRepositoryAdapter contactOwnerRepository;
    private final JpaContactRepositoryAdapter contactRepository;

    @Autowired
    public DatabaseInitializer(JpaContactOwnerRepositoryAdapter contactOwnerRepository,
                               JpaContactRepositoryAdapter contactRepository) {
        this.contactOwnerRepository = contactOwnerRepository;
        this.contactRepository = contactRepository;
    }

    public void init() {
        if (contactOwnerRepository.count() == 0) {
            log.debug(">>>   Filling table ContactOwners with test data.");
            List<ContactOwner> contactOwners = ContactOwnersInitiator.generate();
            contactOwnerRepository.saveAll(contactOwners);
            log.debug(">>>   Table ContactOwners is filled with test data.");
        } else {
            log.debug(">>>   Table ContactOwners already contains test data.");
        }
        if (contactRepository.count() == 0) {
            log.debug(">>>   Filling table Contacts with test data.");
            List<Contact> contacts = ContactsInitiator.generate();
            contactRepository.saveAll(contacts);
            log.debug(">>>   Table Contacts is filled with test data.");
        } else {
            log.debug(">>>   Table Contacts already contains test data.");
        }
    }
}
