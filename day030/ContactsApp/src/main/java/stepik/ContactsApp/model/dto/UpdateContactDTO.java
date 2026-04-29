package stepik.ContactsApp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateContactDTO {
    private Integer id;

    public UpdateContactDTO(int id){
        this.id = id;
    }

    @JsonProperty(index = 10)
    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё]+$", message = "Только буквы")
    @Size(min = 2, max = 50, message = "Длина имени от 2 до 50 символов")
    private String firstName;

    @JsonProperty(index = 20)
    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё,-]+$", message = "Только буквы и дефис")
    @Size(min = 2, max = 50, message = "Длина фамилии от 2 до 50 символов")
    private String lastName;

    @JsonProperty(index = 30)
    @Pattern(regexp = "[Ж,М]")
    private String sex;

    @JsonProperty(index = 40)
    @Pattern(regexp = "[1,2]\\d{3}-[0,1][0-9]-[0-3][0-9]", message = "Формат даты: гггг-ММ-дд")
    private String birthDate;

    @JsonProperty(index = 50)
    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", message = "Формат телефонного номера: +7(xxx)xxx-xx-xx")
    private String telephone;

    @JsonProperty(index = 60)
    @Email(message = "Некорректный адрес eMail")
    private String email;

    private ContactDetailDTO contactDetail;
}
