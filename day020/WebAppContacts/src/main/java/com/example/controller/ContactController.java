package com.example.controller;

import com.example.initiatedata.ContactsInitiator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Contact;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactController() {
        this.contacts = ContactsInitiator.generate();
    }

    // http://localhost:8080/api/contacts/getAll
    @GetMapping("/getAll")
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    // http://localhost:8080/api/contacts/getById?id=2
    @GetMapping("/getById")
    public Contact getContactById(@RequestParam int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(new Contact());
    }
}
