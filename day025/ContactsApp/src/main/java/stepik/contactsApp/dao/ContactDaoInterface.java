package stepik.contactsApp.dao;

import stepik.contactsApp.model.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDaoInterface {

    List<Contact> findAll();

    Contact save(Contact contact);

    boolean deleteById(int id);

    Optional<Contact> findById(int id);

    Optional<Contact> findByEmail(String email);

    Optional<Contact> findByPhone(String phone);


}
