package stepik.contactsApp.service.contacts;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stepik.contactsApp.dao.JpaContactRepositoryAdapter;
import stepik.contactsApp.exception.handler.customException.EntityNotFoundException;
import stepik.contactsApp.exception.handler.customException.ValidationException;
import stepik.contactsApp.model.dto.CreateContactDTO;
import stepik.contactsApp.model.dto.UpdateContactDTO;
import stepik.contactsApp.model.entity.Contact;
import java.util.List;

@Service
public class ContactService implements ContactServiceInterface {
    private final ModelMapper modelMapper;
    private final JpaContactRepositoryAdapter contactRepository;

    @Autowired
    public ContactService(JpaContactRepositoryAdapter contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(int id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Контакт " + id + " не найден"));
    }

    @Override
    public Contact createContact(CreateContactDTO dto) {
        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    throw new ValidationException("Конакт с eMail '" + dto.getEmail() + "' уже существует");
                });
        contactRepository.findByTelephone(dto.getTelephone())
                .ifPresent(contact -> {
                    throw new ValidationException("Конакт с телефоном '" + dto.getTelephone() + "' уже существует");
                });
        Contact contact = modelMapper.map(dto, Contact.class);
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(UpdateContactDTO dto) {
        Contact contactInRepository = contactRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Контакт " + dto.getId() + " не найден"));

        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    if (contact.getId() != dto.getId()) {
                        throw new ValidationException("Конакт с eMail '" + dto.getEmail() + "' уже существует");
                    }
                });

        contactRepository.findByTelephone(dto.getTelephone())
                .ifPresent(contact -> {
                    if (contact.getId() != dto.getId()) {
                        throw new ValidationException("Конакт с телефоном '" + dto.getTelephone() + "' уже существует");
                    }
                });

        Contact contact = modelMapper.map(dto, Contact.class);
        contactInRepository.updateWith(contact);
        return contactRepository.save(contactInRepository);
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Контакт " + id + " не найден");
        }
        return contactRepository.deleteById(id);
    }
}
