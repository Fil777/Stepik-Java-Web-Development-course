package stepik.contactsApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactDetail;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birthDate;
    private String telephone;
    private String email;
    private List<ContactDetail> details;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.sex = contact.getSex();
        this.birthDate = contact.getBirthDate();
        this.telephone = contact.getTelephone();
        this.email = contact.getEmail();
        this.details = contact.getDetails();
    }
}
