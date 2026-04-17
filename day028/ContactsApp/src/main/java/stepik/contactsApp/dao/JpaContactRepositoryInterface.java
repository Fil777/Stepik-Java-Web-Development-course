package stepik.contactsApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stepik.contactsApp.model.entity.Contact;

import java.util.Optional;

public interface JpaContactRepositoryInterface extends JpaRepository<Contact, Integer> {
    Optional<Contact> findByEmail(String email);
    Optional<Contact> findByTelephone(String telephone);
}
