package ru.ksergey.contactApp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;
import ru.ksergey.contactApp.model.dto.CreateContactDto;
import ru.ksergey.contactApp.model.dto.UpdateContactDto;
import ru.ksergey.contactApp.model.entity.Contact;
import ru.ksergey.contactApp.service.ContactService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/get")
    public ResponseEntity<ServerResponse<ArrayList<Contact>>> getContacts() {
        ArrayList<Contact> result = new ArrayList<>(contactService.getAllContacts());
        return ServerResponseHelper.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<Contact>> getContactById(@PathVariable int id) {
        Contact result = contactService.getContactById(id);
        return ServerResponseHelper.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContact(
            @PathVariable int id) {
        contactService.deleteContact(id);
        return ServerResponseHelper.ok(null);
    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<Contact>> createContact(
            @Valid @RequestBody CreateContactDto createContactDto) {
        Contact contact = contactService.createContact(createContactDto);
        return ServerResponseHelper.ok(contact);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponse<Contact>> updateContact(
            @Valid @RequestBody UpdateContactDto updateContactDto) {
        Contact updateContact = contactService.updateContact(updateContactDto);
        return ServerResponseHelper.ok(updateContact);
    }
}
