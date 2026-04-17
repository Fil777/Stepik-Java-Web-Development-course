package stepik.contactsApp.dao;

import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactDetail;
import java.util.List;
import java.util.Optional;

public interface ContactDetailsRepositoryInterface {

    List<ContactDetail> findAll();

    ContactDetail save(ContactDetail contactDetail);

    boolean deleteById(int id);

    Optional<ContactDetail> findById(int id);

    List<ContactDetail> findByContact(Contact contact);

}
