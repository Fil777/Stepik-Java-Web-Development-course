package stepik.contactsApp.service.contacts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stepik.contactsApp.dao.JpaContactOwnerRepositoryAdapter;
import stepik.contactsApp.exception.handler.customException.EntityNotFoundException;
import stepik.contactsApp.exception.handler.customException.ValidationException;
import stepik.contactsApp.model.dto.ContactOwnerDTO;
import stepik.contactsApp.model.dto.CreateContactOwnerDTO;
import stepik.contactsApp.model.dto.UpdateContactOwnerDTO;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactOwnerService implements ContactOwnerServiceInterface {
    private final ModelMapper modelMapper;
    private final JpaContactOwnerRepositoryAdapter contactOwnerRepository;

    @Autowired
    public ContactOwnerService(JpaContactOwnerRepositoryAdapter contactOwnerRepository, ModelMapper modelMapper) {
        this.contactOwnerRepository = contactOwnerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContactOwnerDTO> getContactOwnersAll() {
        return contactOwnerRepository.findAll().stream()
                .map(owner -> modelMapper.map(owner, ContactOwnerDTO.class))
                .collect(Collectors.toList());
//        return contactOwnerRepository.findAll();
    }

    @Override
    public ContactOwner getContactOwner(String id) {
        return contactOwnerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Владелец контактов " + id + "  не найден"));
    }

    @Override
    public ContactOwner createContactOwner(CreateContactOwnerDTO dto) {
        contactOwnerRepository.findByEmail(dto.getEmail())
                .ifPresent(owner -> {
                    throw new ValidationException("Владелец контактов с eMail '" + dto.getEmail() + "' уже существует");
                });

        contactOwnerRepository.findByUsername(dto.getUsername())
                .ifPresent(owner -> {
                    throw new ValidationException("Владелец контактов с логином '" + dto.getUsername() + "' уже существует");
                });

        ContactOwner owner = modelMapper.map(dto, ContactOwner.class);
        return contactOwnerRepository.save(owner);
    }

    @Override
    public ContactOwner updateContactOwner(UpdateContactOwnerDTO dto) {
        ContactOwner ownerInRepository = contactOwnerRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Владелец контактов " + dto.getId() + " не найден"));

        contactOwnerRepository.findByEmail(dto.getEmail())
                .ifPresent(owner -> {
                    if (owner.getId().equals(dto.getId())) {
                        throw new ValidationException("Владелец контактов с eMail '" + dto.getEmail() + "' уже существует");
                    }
                });

        modelMapper.map(dto, ownerInRepository); // мапируются только где not null
        return contactOwnerRepository.save(ownerInRepository);
    }

    @Override
    public boolean deleteContactOwner(String id) {
        if (contactOwnerRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Владелец контактов " + id + " не найден");
        }
        return contactOwnerRepository.deleteById(id);
    }

    public ContactOwner getContactOwnerByUsername(String username) {
        return contactOwnerRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Владелец контактов '" + username + "'  не найден"));
    }

    public ContactOwner getContactOwnerByEmail(String email) {
        return contactOwnerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Владелец контактов с почтой '" + email + "'  не найден"));
    }

    public List<ContactOwner> getContactOwnersByKeyword(String keyword) {
        return contactOwnerRepository.findByKeyword(keyword)
                .orElseThrow(() -> new EntityNotFoundException("Владельцев контактов по слову'" + keyword + "'  не найдено"));
    }

    // метод для получения UserDetailsService для аутентификации
    @Override
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)
                    throws UsernameNotFoundException {

                ContactOwner user = contactOwnerRepository
                        .findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Такого пользователя не существует"));

                return new User(
                        user.getEmail(), // вместо username у нас используется email
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
                );
            }
        };
    }
}
