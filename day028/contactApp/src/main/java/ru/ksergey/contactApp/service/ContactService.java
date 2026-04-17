package ru.ksergey.contactApp.service;

import ru.ksergey.contactApp.model.dto.CreateContactDto;
import ru.ksergey.contactApp.model.dto.UpdateContactDto;
import ru.ksergey.contactApp.model.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact getContactById(int id);

    Contact createContact(CreateContactDto dto);

    Contact updateContact(UpdateContactDto dto);

    boolean deleteContact(int id);
}
