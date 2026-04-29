package stepik.ContactsApp.service.contacts;

import org.springframework.security.core.userdetails.UserDetailsService;
import stepik.ContactsApp.model.dto.ContactOwnerDTO;
import stepik.ContactsApp.model.dto.CreateContactOwnerDTO;
import stepik.ContactsApp.model.dto.UpdateContactOwnerDTO;
import stepik.ContactsApp.model.entity.ContactOwner;

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

    // метод для получения UserDetailsService для аутентификации
    UserDetailsService getUserDetailsService();
}
