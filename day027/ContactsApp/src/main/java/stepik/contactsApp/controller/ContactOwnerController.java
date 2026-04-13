package stepik.contactsApp.controller;

import stepik.contactsApp.common.util.ServerResponseHelper;
import stepik.contactsApp.model.ServerResponse;
import stepik.contactsApp.model.dto.CreateContactOwnerDTO;
import stepik.contactsApp.model.dto.UpdateContactOwnerDTO;
import stepik.contactsApp.model.entity.ContactOwner;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepik.contactsApp.service.contacts.ContactOwnerService;
import stepik.contactsApp.service.contacts.ContactOwnerServiceInterface;
import stepik.contactsApp.service.contacts.ContactService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class ContactOwnerController {

    private final ContactOwnerServiceInterface contactOwnerService;

    private final ContactService contactService;

    @Autowired
    public ContactOwnerController(ContactOwnerService contactOwnerService,
                                  ContactService contactService) {
        this.contactOwnerService = contactOwnerService;
        this.contactService = contactService;
    }

    // http://localhost:8080/api/owners/get
    @GetMapping("/get")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> getContactOwners() {
        var result = new ArrayList<>(contactOwnerService.getContactOwnersAll());
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/owners/get/<id>
    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<ContactOwner>> getContactOwner(
            @PathVariable("id") String id) {
        ContactOwner result = contactOwnerService.getContactOwner(id);
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/owners/delete/<id>
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContactOwner(
            @PathVariable("id") String id) {
        contactOwnerService.deleteContactOwner(id);
        return ServerResponseHelper.ok(null);
    }

    // http://localhost:8080/api/owners/create
    @PostMapping("/create")
    public ResponseEntity<ServerResponse<ContactOwner>> createContactOwner(
            @RequestBody @Valid CreateContactOwnerDTO ownerDTO) {
        ContactOwner result = contactOwnerService.createContactOwner(ownerDTO);
        return ServerResponseHelper.ok(result, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/owners/update/<id>
    @PatchMapping("/update/{id}") //@PutMapping("/update")
    public ResponseEntity<ServerResponse<ContactOwner>> updateContactOwner(
            @PathVariable("id") String id,
            @RequestBody @Valid UpdateContactOwnerDTO ownerDTO) {
        ownerDTO.setId(id);
        ContactOwner result = contactOwnerService.updateContactOwner(ownerDTO);
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/owners/search/username/<username>
    @GetMapping("/search/username/{username}")
    public ResponseEntity<ServerResponse<ContactOwner>> searchByName(
            @PathVariable("username") String username) {
        ContactOwner result = contactOwnerService.getContactOwnerByUsername(username);
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/owners/search/email/<email>
    @GetMapping("/search/email/{email}")
    public ResponseEntity<ServerResponse<ContactOwner>> searchByEmail(
            @PathVariable("email") String email) {
        ContactOwner result = contactOwnerService.getContactOwnerByEmail(email);
        return ServerResponseHelper.ok(result);
    }

    // http://localhost:8080/api/owners/search/keyword/<keyword>
    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchByKeyword(
            @PathVariable("keyword") String keyword) {
        var result = new ArrayList<>(contactOwnerService.getContactOwnersByKeyword(keyword));
        return ServerResponseHelper.ok(result);
    }

}
