package ru.ksergey.contactApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksergey.contactApp.dao.ContactRepository;
import ru.ksergey.contactApp.exception.customException.EntityNotFoundException;
import ru.ksergey.contactApp.exception.customException.ValidationException;
import ru.ksergey.contactApp.model.dto.CreateContactDto;
import ru.ksergey.contactApp.model.dto.UpdateContactDto;
import ru.ksergey.contactApp.model.entity.Contact;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository,
                              ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Контакт не найден"));
    }

    @Override
    public Contact createContact(CreateContactDto dto) {
        contactRepository.findByEmail(dto.getEmail())
                .ifPresent(contact -> {
                    throw new ValidationException("Контакт с таким Email уже существует");
                });

        Contact contact = modelMapper.map(dto, Contact.class);
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(UpdateContactDto dto) {
        Contact existingContact = contactRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Контакт не найден"));

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

        Contact updateContact = modelMapper.map(dto, Contact.class);
        return contactRepository.save(updateContact);
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Контакт не найден");
        }

        return contactRepository.deleteById(id);
    }
}
