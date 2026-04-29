package stepik.ContactsApp.dao;

import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import stepik.ContactsApp.model.entity.Contact;

import java.util.Optional;

@Slf4j
@Primary
@Repository
public class JpaContactRepositoryAdapter implements ContactRepositoryInterface {

    @Delegate
    private final JpaContactRepositoryInterface jpaContactRepository;

    public JpaContactRepositoryAdapter(JpaContactRepositoryInterface jpaContactRepository){
        this.jpaContactRepository = jpaContactRepository;
        log.debug(">>>   Contacts Repository initiated (" + jpaContactRepository.count() + " records).");
    }

    @Override
    public Contact save(Contact contact) {
        return jpaContactRepository.save(contact);
    }

    @Override
    public boolean deleteById(int id) {
        if (jpaContactRepository.existsById(id)) {
            jpaContactRepository.deleteById(id);
            return !jpaContactRepository.existsById(id);
        }
        return false;
    }

    @Override
    public Optional<Contact> findById(int id) {
        return jpaContactRepository.findById(id);
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return jpaContactRepository.findByEmail(email);
    }

    @Override
    public Optional<Contact> findByTelephone(String telephone) {
        return jpaContactRepository.findByTelephone(telephone);
    }
}
