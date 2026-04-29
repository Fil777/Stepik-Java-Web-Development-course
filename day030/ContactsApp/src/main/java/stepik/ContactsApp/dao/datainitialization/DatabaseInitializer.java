package stepik.ContactsApp.dao.datainitialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import stepik.ContactsApp.dao.JpaContactDetailsRepositoryAdapter;
import stepik.ContactsApp.dao.JpaContactOwnerRepositoryAdapter;
import stepik.ContactsApp.dao.JpaContactRepositoryAdapter;
import stepik.ContactsApp.model.entity.Contact;
import stepik.ContactsApp.model.entity.ContactDetail;
import stepik.ContactsApp.model.entity.ContactOwner;

import java.util.List;

@Slf4j
@Component
@Transactional
public class DatabaseInitializer {
    private final JpaContactOwnerRepositoryAdapter contactOwnerRepository;
    private final JpaContactRepositoryAdapter contactRepository;
    private final JpaContactDetailsRepositoryAdapter contactDetailsRepository;

    @Autowired
    public DatabaseInitializer(JpaContactOwnerRepositoryAdapter contactOwnerRepository,
                               JpaContactRepositoryAdapter contactRepository,
                               JpaContactDetailsRepositoryAdapter contactDetailsRepository
    ) {
        this.contactOwnerRepository = contactOwnerRepository;
        this.contactRepository = contactRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    public void init() {

        if (contactOwnerRepository.count() == 0) {
            log.info(">>>   Filling table ContactOwners with test data.");
            List<ContactOwner> contactOwners = ContactOwnersInitiator.generate();
            contactOwnerRepository.saveAll(contactOwners);
            log.info(">>>   Table ContactOwners is filled with test data.");
        } else {
            log.info(">>>   Table ContactOwners already contains test data.");
        }

        if (contactRepository.count() == 0) {
            log.info(">>>   Filling table Contacts with test data.");
            List<ContactOwner> owners = contactOwnerRepository.findAll();
            for (ContactOwner owner : owners) {
                List<Contact> contacts = ContactsInitiator.generate(owner);
                contactRepository.saveAll(contacts);
            }
            log.info(">>>   Table Contacts is filled with test data.");
        } else {
            log.info(">>>   Table Contacts already contains test data.");
        }

        if (contactDetailsRepository.count() == 0) {
            log.info(">>>   Filling table Contact Details with test data.");
            List<Contact> contacts = contactRepository.findAll();
            for (Contact contact : contacts) {
                List<ContactDetail> details = ContactDetailsInitiator.generate(contact);
                contactDetailsRepository.saveAll(details);
            }
        } else {
            log.info(">>>   Table Contact Details is filled with test data.");
        }
    }
}
