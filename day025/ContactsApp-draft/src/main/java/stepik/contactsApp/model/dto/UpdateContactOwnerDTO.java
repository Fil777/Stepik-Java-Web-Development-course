package stepik.contactsApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateContactOwnerDTO {
    private String id;

    private String description;

    @Email(message = "Некорректный eMail")
    private String email;

    @Size(message = "Полное имя должно содержать от 2 до 50 символов")
    private String fullName;
}
