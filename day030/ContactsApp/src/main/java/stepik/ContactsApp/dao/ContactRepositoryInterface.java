package stepik.ContactsApp.dao;

import stepik.ContactsApp.model.entity.Contact;
import java.util.List;
import java.util.Optional;

public interface ContactRepositoryInterface {

    List<Contact> findAll();

    Contact save(Contact contact);

    boolean deleteById(int id);

    Optional<Contact> findById(int id);

    Optional<Contact> findByEmail(String email);

    Optional<Contact> findByTelephone(String telephone);


}
