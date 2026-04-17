package ru.ksergey.contactApp.dao;

import lombok.experimental.Delegate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.ksergey.contactApp.model.entity.ContactOwner;

@Primary
@Repository
public class JpaContactOwnerRepositoryAdapter implements ContactOwnerRepository {

    @Delegate
    private final JpaContactOwnerRepository jpaContactOwnerRepository;

    public JpaContactOwnerRepositoryAdapter(JpaContactOwnerRepository jpaContactOwnerRepository) {
        this.jpaContactOwnerRepository = jpaContactOwnerRepository;
    }

    @Override
    public ContactOwner save(ContactOwner contactOwner) {
        return jpaContactOwnerRepository.save(contactOwner);
    }

    @Override
    public boolean deleteById(String id) {
        if (jpaContactOwnerRepository.existsById(id)) {
            jpaContactOwnerRepository.deleteById(id);
            return !jpaContactOwnerRepository.existsById(id);
        }
        return false;
    }
}
