package stepik.ContactsApp.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stepik.ContactsApp.model.entity.Contact;

import java.util.Optional;

public interface JpaContactRepositoryInterface extends JpaRepository<Contact, Integer> {
    //@EntityGraph(attributePaths = "details")
    Optional<Contact> findById(Integer id);

    Optional<Contact> findByEmail(String email);

    Optional<Contact> findByTelephone(String telephone);
}
