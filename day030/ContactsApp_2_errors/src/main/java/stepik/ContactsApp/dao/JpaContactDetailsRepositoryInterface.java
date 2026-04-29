package stepik.ContactsApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stepik.ContactsApp.model.entity.ContactDetail;

public interface JpaContactDetailsRepositoryInterface extends JpaRepository<ContactDetail, Integer> {
}
