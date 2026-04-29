package stepik.ContactsApp.dao;

import stepik.ContactsApp.model.dto.ContactOwnerDTO;
import stepik.ContactsApp.model.entity.ContactOwner;

import java.util.List;
import java.util.Optional;

public interface ContactOwnerRepositoryInterface {

        List<ContactOwner> findAll();

        ContactOwner save(ContactOwner owner);

        boolean deleteById(String id);

        Optional<ContactOwner> findById(String id);

        Optional<ContactOwner> findByEmail(String email);

        Optional<ContactOwner> findByUsername(String username);

        Optional<List<ContactOwner>> findByKeyword(String keyword);

}



