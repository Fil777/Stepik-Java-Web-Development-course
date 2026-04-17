package stepik.contactsApp.dao;

import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import stepik.contactsApp.model.entity.ContactOwner;

@Slf4j // Logging
@Primary
@Repository
public class JpaContactOwnerRepositoryAdapter implements ContactOwnerRepositoryInterface {

    @Delegate // Важно!!! Теперь можно не писать код ниже в комментариях.
    private final JpaContactOwnerRepositoryInterface jpaContactOwnerRepository;

    public JpaContactOwnerRepositoryAdapter(JpaContactOwnerRepositoryInterface jpaContactOwnerRepository) {
        this.jpaContactOwnerRepository = jpaContactOwnerRepository;
        log.debug(">>>   Contact Owners Repository initiated ("
                + jpaContactOwnerRepository.count() + " records).");
    }

    @Override
    public ContactOwner save(ContactOwner owner) {
        return jpaContactOwnerRepository.save(owner);
    }

    @Override
    public boolean deleteById(String id) {
        if (jpaContactOwnerRepository.existsById(id)) {
            jpaContactOwnerRepository.deleteById(id);
            return !jpaContactOwnerRepository.existsById(id);
        }
        return false;
    }

//    @Override
//    public Optional<ContactOwner> findById(String id) {
//        return jpaContactOwnerRepository.findById(id);
//    }
//
//    @Override
//    public List<ContactOwner> findAll() {
//        return jpaContactOwnerRepository.findAll();
//    }
//
//    @Override
//    public Optional<ContactOwner> findByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public Optional<ContactOwner> findByUsername(String username) {
//        return null;
//    }
//
//    @Override
//    public Optional<List<ContactOwner>> findByKeyword(String keyword) {
//        return null;
//    }

}
