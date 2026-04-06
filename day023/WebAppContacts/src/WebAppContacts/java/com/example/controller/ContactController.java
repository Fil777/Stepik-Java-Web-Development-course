package com.example.controller;

import com.example.common.util.ServerResponseHelper;
import com.example.initiatedata.ContactsInitiator;

import com.example.model.ServerResponse;
import com.example.model.dto.CreateContactDTO;
import com.example.model.dto.UpdateContactDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.entity.Contact;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ModelMapper modelMapper;
    private ArrayList<Contact> contacts;// = new ArrayList<>();

    public ContactController() {
        this.contacts = ContactsInitiator.generate();
    }

    // http://localhost:8080/api/contacts/hello
    @GetMapping("/hello")
    public ResponseEntity<ServerResponse<String>> sayHello() {
        return ServerResponseHelper.ok("Hello!");
    }

    // http://localhost:8080/api/contacts/get
    @GetMapping("/get")
    public ResponseEntity<ServerResponse<ArrayList<Contact>>> getContacts() {
        return ServerResponseHelper.ok(this.contacts);
    }

    // http://localhost:8080/api/contacts/get/2
    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<Contact>> getContactById(@PathVariable("id") int id) {
        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (contact == null) {
            return ServerResponseHelper.notFound(null);
        } else {
            return ServerResponseHelper.ok(contact);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContact(@PathVariable("id") int id) {
        boolean removed = contacts.removeIf(c -> c.getId() == id);
        if (removed) {
            return ServerResponseHelper.ok(null);
        } else {
            return ServerResponseHelper.notFound(null, "Отсутствует контакт с id = " + id);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<Contact>> createContact(
            @RequestBody @Valid CreateContactDTO contactDTO) {

        int newId = contacts.stream()
                .mapToInt(c -> c.getId())
                .max()
                .orElse(0) + 1;

        if (contactWithThisEmail(contactDTO.getEmail()) != null) {
            return ServerResponseHelper.conflict(null, "Контакт с eMail "
                    + contactDTO.getEmail() + " уже существует");
        }

        if (contactWithThisPhone(contactDTO.getTelephone()) != null) {
            return ServerResponseHelper.conflict(null, "Контакт с телефоном "
                    + contactDTO.getTelephone() + " уже существует");
        }

        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contact.setId(newId);
        contacts.add(contact);

        return ServerResponseHelper.ok(contact, HttpStatus.CREATED);
    }

    @PatchMapping("/update") //@PutMapping("/update")
    public ResponseEntity<ServerResponse<Contact>> updateContact(
            @RequestBody @Valid UpdateContactDTO contactDTO) {

        Contact contactInList = contactWithThisId(contactDTO.getId());
        if (contactInList == null) {
            return ServerResponseHelper.notFound(null, "Отсутствует контакт с id = "
                    + contactDTO.getId());
        }

        Contact check1 = contactWithThisEmail(contactDTO.getEmail());
        if (check1 != null && check1 != contactInList ) {
            return ServerResponseHelper.conflict(null, "Контакт с eMail "
                    + contactDTO.getEmail() + " уже существует");
        }

        Contact check2 = contactWithThisPhone(contactDTO.getTelephone());
        if (check2 != null && check2 != contactInList) {
            return ServerResponseHelper.conflict(null, "Контакт с телефоном "
                    + contactDTO.getTelephone() + " уже существует");
        }

        Contact updatedContact = modelMapper.map(contactDTO, Contact.class);
        contactInList.updateWith(updatedContact);

        return ServerResponseHelper.ok(contactInList);

    }

    private Contact contactWithThisId(int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Contact contactWithThisEmail(String email) {
        return contacts.stream()
                .filter(contact -> contact.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    private Contact contactWithThisPhone(String phone) {
        return contacts.stream()
                .filter(contact -> contact.getTelephone().equalsIgnoreCase(phone))
                .findFirst()
                .orElse(null);
    }

}
