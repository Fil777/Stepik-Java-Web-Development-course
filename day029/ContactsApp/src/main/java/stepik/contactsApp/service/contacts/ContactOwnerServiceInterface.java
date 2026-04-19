package stepik.contactsApp.service.contacts;

import stepik.contactsApp.model.dto.ContactOwnerDTO;
import stepik.contactsApp.model.dto.CreateContactOwnerDTO;
import stepik.contactsApp.model.dto.UpdateContactOwnerDTO;
import stepik.contactsApp.model.entity.ContactOwner;

import java.util.List;

public interface ContactOwnerServiceInterface {
    List<ContactOwnerDTO> getContactOwnersAll();
    ContactOwner getContactOwner(String id);
    ContactOwner createContactOwner(CreateContactOwnerDTO dto);
    ContactOwner updateContactOwner(UpdateContactOwnerDTO dto);
    boolean deleteContactOwner(String id);
    ContactOwner getContactOwnerByUsername(String username);
    ContactOwner getContactOwnerByEmail(String email);
    List<ContactOwner> getContactOwnersByKeyword(String keyword);
}
