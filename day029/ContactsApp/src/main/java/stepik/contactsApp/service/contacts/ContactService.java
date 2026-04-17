package stepik.contactsApp.service.contacts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stepik.contactsApp.dao.JpaContactRepositoryAdapter;
import stepik.contactsApp.exception.handler.customException.EntityNotFoundException;
import stepik.contactsApp.exception.handler.customException.ValidationException;
import stepik.contactsApp.model.dto.ContactDetailDTO;
import stepik.contactsApp.model.dto.CreateContactDTO;
import stepik.contactsApp.model.dto.UpdateContactDTO;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactDetail;

import java.util.List;

@Service
@Transactional
public class ContactService implements ContactServiceInterface {
    private final ModelMapper modelMapper;
    private final JpaContactRepositoryAdapter contactRepository;

    @Autowired
    public ContactService(JpaContactRepositoryAdapter contactRepository,
                             ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(int id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Контакт " + id + " не найден"));
        return contact;
    }

    @Override
    public Contact createContact(CreateContactDTO dto) {
        // checking uniqueness of email & phone number
        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    throw new ValidationException("Конакт с eMail '" + dto.getEmail() + "' уже существует");
                });
        contactRepository.findByTelephone(dto.getTelephone())
                .ifPresent(contact -> {
                    throw new ValidationException("Конакт с телефоном '" + dto.getTelephone() + "' уже существует");
                });

        // creating new contact
        Contact newContact = modelMapper.map(dto, Contact.class);

        // creating contact detail and establishing links one-to-one
        if (dto.getContactDetail() != null){
            ContactDetail contactDetail = modelMapper.map(dto.getContactDetail(), ContactDetail.class);
            contactDetail.setContact(newContact);
            newContact.setContactDetail(contactDetail);
        }

        // saving new contact data
        newContact.setId(null); // id generates automatically
        return contactRepository.save(newContact);
    }

    @Override
    public Contact updateContact(UpdateContactDTO dto) {
        // looking for the contact in repository by its Id
        Contact contactInRepository = contactRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Контакт " + dto.getId() + " не найден"));

        // checking uniqueness of email & phone number
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

        // creating new contact
        Contact newContact = modelMapper.map(dto, Contact.class);

        // updating existing contact with new one
        contactInRepository.updateWith(newContact);
        // creating new detail
        ContactDetailDTO detailDTO = dto.getContactDetail();
        ContactDetail newDetail = modelMapper.map(detailDTO, ContactDetail.class);
        // Id of new datail should be the same as the one on the contact
        newDetail.setId(contactInRepository.getContactDetail().getId());
        // updating existing detail with new data
        contactInRepository.getContactDetail().updateWith(newDetail);

        // saving updated contact data
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
