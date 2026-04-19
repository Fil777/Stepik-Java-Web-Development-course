package ru.ksergey.contactApp.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksergey.contactApp.dao.ContactOwnerRepository;
import ru.ksergey.contactApp.dao.ContactRepository;
import ru.ksergey.contactApp.exception.customException.EntityNotFoundException;
import ru.ksergey.contactApp.exception.customException.ValidationException;
import ru.ksergey.contactApp.model.dto.CreateContactDto;
import ru.ksergey.contactApp.model.dto.UpdateContactDto;
import ru.ksergey.contactApp.model.entity.Contact;
import ru.ksergey.contactApp.model.entity.ContactDetail;
import ru.ksergey.contactApp.model.entity.ContactOwner;

import java.util.List;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    private final ContactOwnerRepository contactOwnerRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository,
            ModelMapper modelMapper,
            ContactOwnerRepository contactOwnerRepository) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
        this.contactOwnerRepository = contactOwnerRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        log.info("  >> Кто-то обращается к getAllContacts");
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {

        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Контакт не найден"));
    }

    @Override
    public Contact createContact(CreateContactDto dto) {

        ContactOwner owner = contactOwnerRepository
                .findById(dto.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("Такой владелец не найден"));

        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    throw new ValidationException("Контакт с таким Email уже существует");
                });

        Contact contact = modelMapper.map(dto, Contact.class);

        contact.setOwner(owner);
        owner.getContacts().add(contact);

        if (dto.getContactDetail() != null) {
            ContactDetail contactDetail = modelMapper.map(
                    dto.getContactDetail(),
                    ContactDetail.class);
            contactDetail.setContact(contact);
            contact.setContactDetail(contactDetail);
        }

        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(UpdateContactDto dto) {
        ContactOwner owner = contactOwnerRepository
                .findById(dto.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("Такой владелец не найден"));

        Contact existingContact = contactRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Контакт не найден"));

        if (!existingContact.getOwner().getId().equalsIgnoreCase(dto.getOwnerId())) {
            throw new ValidationException("У вас нет прав на обновление этого контакта");
        }

        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    if (contact.getId() != dto.getId()) {
                        throw new ValidationException("Контакт с таким Email уже существует");
                    }
                });

        contactRepository.findByTelephone(dto.getTelephone())
                .ifPresent(contact -> {
                    if (contact.getId() != dto.getId()) {
                        throw new ValidationException("Контакт с таким телефоном уже существует");
                    }
                });

        modelMapper.map(dto, existingContact);
        return contactRepository.save(existingContact);
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Контакт не найден");
        }

        return contactRepository.deleteById(id);
    }
}
