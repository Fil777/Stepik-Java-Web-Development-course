package stepik.ContactsApp.dao;

import stepik.ContactsApp.model.entity.Contact;
import stepik.ContactsApp.model.entity.ContactDetail;
import java.util.List;
import java.util.Optional;

public interface ContactDetailsRepositoryInterface {

    List<ContactDetail> findAll();

    ContactDetail save(ContactDetail contactDetail);

    boolean deleteById(int id);

    Optional<ContactDetail> findById(int id);

}
