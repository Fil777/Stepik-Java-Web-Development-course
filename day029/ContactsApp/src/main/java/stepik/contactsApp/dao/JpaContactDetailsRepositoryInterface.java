package stepik.contactsApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stepik.contactsApp.model.entity.ContactDetail;

public interface JpaContactDetailsRepositoryInterface extends JpaRepository<ContactDetail, Integer> {
}
