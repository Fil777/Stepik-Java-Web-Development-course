package stepik.contactsApp.dao;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import stepik.contactsApp.datainitiator.ContactOwnersInitiator;
import stepik.contactsApp.model.entity.ContactOwner;
import stepik.contactsApp.model.enums.AppRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContactOwnerRepository implements ContactOwnerRepositoryInterface {

    private final List<ContactOwner> contactOwners;// = new ArrayList<>();
    private final ModelMapper modelMapper;

    public ContactOwnerRepository(ModelMapper modelMapper) {
        this.contactOwners = ContactOwnersInitiator.generate();
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContactOwner> findAll() {
        return new ArrayList<>(contactOwners);
    }

    @Override
    public ContactOwner save(ContactOwner owner) {
        if (owner.getId().isBlank()) {
            ContactOwner newOwner = new ContactOwner();
            owner.setId(newOwner.getId());
            newOwner.updateWith(owner);
            contactOwners.add(newOwner);
            return newOwner;
        } else {
            Optional<ContactOwner> opOwner;
            ContactOwner ownerInList;
            opOwner = findById(owner.getId());
            if (opOwner.isPresent()) {
                ownerInList = opOwner.get();
                ownerInList.updateWith(owner);
                return ownerInList;
            } else {
                contactOwners.add(owner);
                return owner;
            }
        }
    }

    @Override
    public boolean deleteById(String id) {
        return contactOwners.removeIf(owner -> owner.getId().equals(id));
    }

    @Override
    public Optional<ContactOwner> findById(String id) {
        return contactOwners.stream()
                .filter(owner -> owner.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<ContactOwner> findByEmail(String email) {
        return contactOwners.stream()
                .filter(owner -> owner.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Optional<ContactOwner> findByUsername(String username) {
        return contactOwners.stream()
                .filter(owner -> owner.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public Optional<List<ContactOwner>> findByKeyword(String keyword) {
        String word = keyword.toLowerCase();
        return Optional.of(contactOwners.stream()
                .filter(owner -> owner.getUsername().toLowerCase().contains(word)
                        || owner.getFullName().toLowerCase().contains(word)
                        || owner.getDescription().toLowerCase().contains(word)
                        || owner.getEmail().toLowerCase().contains(word))
                .toList());
    }

}
