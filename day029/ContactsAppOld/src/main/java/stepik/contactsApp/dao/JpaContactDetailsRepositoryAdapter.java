package stepik.contactsApp.dao;

import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Primary
@Repository
public class JpaContactDetailsRepositoryAdapter implements ContactDetailsRepositoryInterface {

    @Delegate
    private final JpaContactDetailsRepositoryInterface jpaContactDetailsRepository;

    public JpaContactDetailsRepositoryAdapter(
            JpaContactDetailsRepositoryInterface jpaContactDetailsRepository
    ){
        this.jpaContactDetailsRepository = jpaContactDetailsRepository;
        log.debug(">>>   Contact Details Repository initiated ("
                + jpaContactDetailsRepository.count() + " records).");
    }

    @Override
    public Optional<ContactDetail> findById(int id) {
        return (Optional) jpaContactDetailsRepository.findById(id);
    }

    @Override
    public ContactDetail save(ContactDetail contactDetail) {
        return jpaContactDetailsRepository.save(contactDetail);
    }

    @Override
    public boolean deleteById(int id) {
        if (jpaContactDetailsRepository.existsById(id)) {
            jpaContactDetailsRepository.deleteById(id);
            return !jpaContactDetailsRepository.existsById(id);
        }
        return false;
    }

    @Override
    public List<ContactDetail> findByContact(Contact contact){
        List<ContactDetail> details = new ArrayList<>();
        if (contact != null) {
            details = findAll().stream()
                    .filter(d -> d.getContact().getId() == contact.getId()).toList();
        }
        return details;
    }
}