package stepik.contactsApp.controller;

import stepik.contactsApp.common.util.ServerResponseHelper;
import stepik.contactsApp.datainitiator.ContactsInitiator;

import stepik.contactsApp.model.ServerResponse;
import stepik.contactsApp.model.dto.CreateContactDTO;
import stepik.contactsApp.model.dto.UpdateContactDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.service.ContactService;
import stepik.contactsApp.service.ContactServiceInterface;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactServiceInterface contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    // http://localhost:8080/api/contacts/hello
    @GetMapping("/hello")
    public ResponseEntity<ServerResponse<String>> sayHello() {
        return ServerResponseHelper.ok("Hello!");
    }

    // http://localhost:8080/api/contacts/get
    @GetMapping("/get")
    public ResponseEntity<ServerResponse<List<Contact>>> getContacts() {
        var result = new ArrayList<>(contactService.getAllContacts());
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/contacts/get/2
    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<Contact>> getContactById(
            @PathVariable("id") int id) {
        Contact result = contactService.getContact(id);
        return ServerResponseHelper.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContact(
            @PathVariable("id") int id) {
        contactService.deleteContact(id);
        return ServerResponseHelper.ok(null);
    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<Contact>> createContact(
            @RequestBody @Valid CreateContactDTO contactDTO) {
        Contact result = contactService.createContact(contactDTO);
        return ServerResponseHelper.ok(result, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}") //@PutMapping("/update")
    public ResponseEntity<ServerResponse<Contact>> updateContact(
            @PathVariable("id") int id,
            @RequestBody @Valid UpdateContactDTO contactDTO) {
        contactDTO.setId(id);
        Contact result = contactService.updateContact(contactDTO);
        return ServerResponseHelper.ok(result);
    }

}
