package stepik.contactsApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.List;
import java.util.Optional;

public interface JpaContactOwnerRepositoryInterface extends JpaRepository<ContactOwner, String> {

    Optional<ContactOwner> findByUsername(String username);

    Optional<ContactOwner> findByEmail(String email);

    @Query("SELECT co FROM ContactOwner co WHERE "
            + "LOWER(co.username) LIKE LOWER(CONCAT('%', :keyword, '%')) "
            + "OR LOWER(co.description) LIKE LOWER(CONCAT('%', :keyword, '%')) "
            + "OR LOWER(co.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Optional<List<ContactOwner>> findByKeyword(String keyword);
}
