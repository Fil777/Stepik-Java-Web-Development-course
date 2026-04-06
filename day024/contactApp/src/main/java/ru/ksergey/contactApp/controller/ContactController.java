package ru.ksergey.contactApp.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;
import ru.ksergey.contactApp.model.dto.CreateContactDto;
import ru.ksergey.contactApp.model.dto.UpdateContactDto;
import ru.ksergey.contactApp.model.entity.Contact;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ModelMapper modelMapper;

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public ContactController() {
        for (int i = 1; i < 10; i++) {
            contacts.add(new Contact(
                    i,
                    "Имя " + i,
                    "Фамилия " + i,
                    "+7 111 222 33 3" + i,
                    "user" + i + "@ksergey.ru"));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ServerResponse<ArrayList<Contact>>> getContacts() {
        return ServerResponseHelper.ok(this.contacts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<Contact>> getContactById(@PathVariable int id) {
        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contact == null) {
            return ServerResponseHelper.notFound(null);
        }

        return ServerResponseHelper.ok(contact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContact(
            @PathVariable int id) {
        boolean removed = contacts.removeIf(contact -> contact.getId() == id);

        if (removed) {
            return ServerResponseHelper.ok(null);
        } else {
            return ServerResponseHelper.notFound(null,
                    Collections.singletonList("Контакт с указанным ID не был найден"));
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<Contact>> createContact(
            @Valid @RequestBody CreateContactDto createContactDto) {

        int newId = contacts.stream()
                .mapToInt(Contact::getId)
                .max()
                .orElse(0) + 1;

        boolean emailExists = contacts.stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(createContactDto.getEmail()));

        if (emailExists) {
            return ServerResponseHelper.conflict(null,
                    Collections.singletonList("Контакт с таким email уже существует"));
        }

        Contact contact = modelMapper.map(createContactDto, Contact.class);
        contact.setId(newId);

        contacts.add(contact);

        return ServerResponseHelper.created(contact);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponse<Contact>> updateContact(
            @Valid @RequestBody UpdateContactDto updateContactDto) {

        Contact existingContact = contacts.stream()
                .filter(c -> c.getId() == updateContactDto.getId())
                .findFirst()
                .orElse(null);

        if (existingContact == null) {
            return ServerResponseHelper.notFound(null,
                    Collections.singletonList("Контакт с указанным ID не найден"));
        }

        boolean emailExists = contacts.stream()
                .filter(c -> c.getId() != updateContactDto.getId())
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(updateContactDto.getEmail()));

        if (emailExists) {
            return ServerResponseHelper.conflict(null,
                    Collections.singletonList("Контакт с указанным Email уже существует"));
        }

        boolean phoneExists = contacts.stream()
                .filter(c -> c.getId() != updateContactDto.getId())
                .anyMatch(c -> c.getTelephone().equals(updateContactDto.getTelephone()));

        if (phoneExists) {
            return ServerResponseHelper.conflict(null,
                    Collections.singletonList("Контакт с указанным телефоном уже существует"));
        }

        Contact updateContact = modelMapper.map(updateContactDto, Contact.class);

        int index = contacts.indexOf(existingContact);
        contacts.set(index, updateContact);
        
        return ServerResponseHelper.ok(updateContact);
    }
}
