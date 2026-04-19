package stepik.contactsApp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
public class CreateContactDTO {
    private final int id = 0;
    @JsonProperty(index = 10)
    @NotEmpty(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё]+$", message = "Только буквы")
    @Size(min = 2, max = 50, message = "Длина имени от 2 до 50 символов")
    private String firstName;
    @JsonProperty(index = 20)
    @NotEmpty(message = "Фамилия не может быть пустой")
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
    @NotEmpty(message = "Номер телефона обязателен")
    private String telephone;
    @JsonProperty(index = 60)
    @Email(message = "Некорректный адрес eMail")
    @NotEmpty(message = "Почтовый адрес обязателен")
    private String email;

    private ContactDetailDTO contactDetail;

    @NotEmpty(message = "Id владельца должно быть заполнено")
    @JsonProperty(index = 1)
    private String ownerId;

}
