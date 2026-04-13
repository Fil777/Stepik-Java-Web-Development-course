package ru.ksergey.contactApp.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;
import ru.ksergey.contactApp.model.dto.CreateContactOwnerDto;
import ru.ksergey.contactApp.model.dto.UpdateContactOwnerDto;
import ru.ksergey.contactApp.model.entity.ContactOwner;
import ru.ksergey.contactApp.service.ContactOwnerService;

import java.util.List;

@RestController
@RequestMapping("api/owner")
public class ContactOwnerController {
    private final ContactOwnerService contactOwnerService;

    @Autowired
    public ContactOwnerController(ContactOwnerService contactOwnerService) {
        this.contactOwnerService = contactOwnerService;
    }

    @GetMapping("/get")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> getAllContactOwner() {
        return ServerResponseHelper.ok(contactOwnerService.getAllContactOwners());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<ContactOwner>> getContactOwnerById(
            @PathVariable String id) {
        return ServerResponseHelper.ok(contactOwnerService.getContactOwnerById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<ContactOwner>> createContactOwner(
            @Valid @RequestBody CreateContactOwnerDto createDto) {
        ContactOwner contactOwner = contactOwnerService.createContactOwner(createDto);
        return ServerResponseHelper.ok(contactOwner);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponse<ContactOwner>> updateContactOwner(
            @Valid @RequestBody UpdateContactOwnerDto dto) {
        ContactOwner updateContactOwner = contactOwnerService.updateContactOwner(dto);
        return ServerResponseHelper.ok(updateContactOwner);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContactOwner(
            @PathVariable String id) {
        contactOwnerService.deleteContactOwner(id);
        return ServerResponseHelper.ok(null);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchByName(
            @PathVariable String name) {
        List<ContactOwner> found = contactOwnerService
                .searchContactOwnersByUsername(name);
        return ServerResponseHelper.ok(found);
    }

    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchByKeyword(
            @PathVariable String keyword) {
        List<ContactOwner> found = contactOwnerService
                .searchContactOwnersByKeyword(keyword);
        return ServerResponseHelper.ok(found);
    }
}
