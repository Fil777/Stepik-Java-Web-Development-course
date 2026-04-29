package stepik.ContactsApp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import stepik.ContactsApp.common.utils.serverresponse.ServerResponseHelper;
import stepik.ContactsApp.exception.handler.customException.ValidationException;
import stepik.ContactsApp.model.ServerResponse;
import stepik.ContactsApp.model.dto.CreateContactDTO;
import stepik.ContactsApp.model.entity.Contact;
import stepik.ContactsApp.service.contacts.ContactOwnerService;
import stepik.ContactsApp.service.contacts.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactManagerController {
    private final ContactOwnerService contactOwnerService;
    private final ContactService contactService;

    @Autowired
    public ContactManagerController(ContactOwnerService contactOwnerService, ContactService contactService) {
        this.contactOwnerService = contactOwnerService;
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<ServerResponse<List<Contact>>> getContactOwnerById(
            Authentication authentication
    ) {
        String ownerId = resolveOwnerId(authentication);
        List<Contact> result = contactOwnerService.getContactOwner(ownerId).getContacts();
        return ServerResponseHelper.ok(result);
    }

    @PostMapping
    public ResponseEntity<ServerResponse<Contact>> createContact(
            @Valid @RequestBody CreateContactDTO createContactDTO,
            Authentication authentication
    ) {
        createContactDTO.setOwnerId(resolveOwnerId(authentication));
        Contact contact = contactService.createContact(createContactDTO);
        return ServerResponseHelper.ok(contact);
    }

    private String resolveOwnerId(Authentication authentication) {
        if (authentication == null || authentication.getName() == null || authentication.getName().isBlank()) {
            throw new ValidationException("Пользователь не аутентифицирован");
        }

        return contactOwnerService.getContactOwnerByEmail(authentication.getName()).getId();
    }

}
