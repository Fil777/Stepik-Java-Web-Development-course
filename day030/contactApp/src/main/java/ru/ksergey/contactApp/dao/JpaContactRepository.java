package ru.ksergey.contactApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksergey.contactApp.model.entity.Contact;

import java.util.Optional;

public interface JpaContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findByEmail(String email);

    Optional<Contact> findByTelephone(String telephone);
}
