package stepik.contactsApp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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

    @JsonProperty(index = 10)
    private String id;

    @JsonProperty(index = 20)
    private String description;

    @JsonProperty(index = 30)
    @Email(message = "Некорректный eMail")
    private String email;

    @JsonProperty(index = 40)
    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё,\\-, ]+$", message = "Только буквы и дефис")
    @Size(message = "Полное имя должно содержать от 2 до 50 символов")
    private String fullName;
}
