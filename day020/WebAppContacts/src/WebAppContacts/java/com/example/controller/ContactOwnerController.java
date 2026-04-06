package com.example.controller;

import com.example.common.util.ServerResponseHelper;
import com.example.datainitiator.ContactOwnersInitiator;
import com.example.model.ServerResponse;
import com.example.model.dto.CreateContactOwnerDTO;
import com.example.model.dto.UpdateContactDTO;
import com.example.model.dto.UpdateContactOwnerDTO;
import com.example.model.entity.Contact;
import com.example.model.entity.ContactOwner;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/owners")
public class ContactOwnerController {
    @Autowired
    private ModelMapper modelMapper;
    private List<ContactOwner> contactOwners = new ArrayList<>();

    public ContactOwnerController() {
        this.contactOwners = ContactOwnersInitiator.generate();
    }

    // http://localhost:8080/api/owners/get
    @GetMapping("/get")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> getContactOwners() {
        return ServerResponseHelper.ok(this.contactOwners);
    }

    // http://localhost:8080/api/owners/get/<id>
    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<ContactOwner>> getContactOwner(@PathVariable("id") String id) {
        ContactOwner ownerInList = ownerWithThisId(id);
        if (ownerInList == null) {
            return ServerResponseHelper.notFound(null, "Отсутствует пользователь с id = " + id);
        } else {
            return ServerResponseHelper.ok(ownerInList);
        }
    }

    // http://localhost:8080/api/owners/create
    @PostMapping("/create")
    public ResponseEntity<ServerResponse<ContactOwner>> createContactOwner(
            @RequestBody @Valid CreateContactOwnerDTO ownerDTO) {

        if (contactWithThisEmail(ownerDTO.getEmail()) != null) {
            return ServerResponseHelper.conflict(null, "Пользователь с eMail "
                    + ownerDTO.getEmail() + " уже существует");
        }

        ContactOwner owner = modelMapper.map(ownerDTO, ContactOwner.class);
        owner.setId(UUID.randomUUID().toString());
        contactOwners.add(owner);

        return ServerResponseHelper.ok(owner, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/owners/delete/<id>
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContactOwner(
            @PathVariable("id") String id) {
        boolean removed = contactOwners.removeIf(c -> c.getId().equals(id));
        if (removed) {
            return ServerResponseHelper.ok(null);
        } else {
            return ServerResponseHelper.notFound(null, "Отсутствует пользователь с id = " + id);
        }
    }

    // http://localhost:8080/api/owners/update/<id>
    @PatchMapping("/update/{id}") //@PutMapping("/update")
    public ResponseEntity<ServerResponse<ContactOwner>> updateContactOwner(
            @PathVariable("id") String id,
            @RequestBody @Valid UpdateContactOwnerDTO contactOwnerDTO) {

        ContactOwner ownerInList = ownerWithThisId(id);
        if (ownerInList == null) {
            return ServerResponseHelper.notFound(null, "Отсутствует пользователь с id = " + id);
        }

        ContactOwner check1 = contactWithThisEmail(contactOwnerDTO.getEmail());
        if (check1 != null && check1 != ownerInList ) {
            return ServerResponseHelper.conflict(null, "Пользователь с eMail "
                    + contactOwnerDTO.getEmail() + " уже существует");
        }

        contactOwnerDTO.setId(id);
        ContactOwner updatedContactOwner = modelMapper.map(contactOwnerDTO, ContactOwner.class);
        ownerInList.updateWith(updatedContactOwner);

        return ServerResponseHelper.ok(ownerInList);

    }

    // http://localhost:8080/api/owners/search/username/<username>
    @GetMapping("/search/username/{username}")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchByName(
            @PathVariable("username") String username) {
        List<ContactOwner> found = contactOwners.stream()
                .filter(owner -> owner.getUsername().equalsIgnoreCase(username))
                .toList();
        return ServerResponseHelper.ok(found);
    }

    // http://localhost:8080/api/owners/search/keyword/<keyword>
    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchByKeyword(
            @PathVariable("keyword") String keyword) {
        String word = keyword.toLowerCase();
        List<ContactOwner> found = contactOwners.stream()
                .filter(owner -> owner.getUsername().toLowerCase().contains(word)
                        || owner.getFullName().toLowerCase().contains(word)
                        || owner.getDescription().toLowerCase().contains(word)
                        || owner.getEmail().toLowerCase().contains(word))
                .toList();
        return ServerResponseHelper.ok(found);
    }

    //--------------------------------------------------------------------------------------

    private ContactOwner ownerWithThisId(String id) {
        return contactOwners.stream()
                .filter(owner -> owner.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private ContactOwner contactWithThisEmail(String email) {
        return contactOwners.stream()
                .filter(owner -> owner.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

}
