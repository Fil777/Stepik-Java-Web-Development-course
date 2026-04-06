package stepik.contactsApp.model.dto;

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

    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё]+$", message = "Только буквы")
    @Size(min = 2, max = 50, message = "Длина имени от 2 до 50 символов")
    private String firstName;

    @Pattern(regexp = "^[A-Z,А-Я,Ё][A-Z,А-Я,Ё,a-z,а-я,ё,-]+$", message = "Только буквы и дефис")
    @Size(min = 2, max = 50, message = "Длина фамилии от 2 до 50 символов")
    private String lastName;

    @Pattern(regexp = "[Ж,М]")
    private String sex;

    @Pattern(regexp = "[1,2]\\d{3}-[0,1][0-9]-[0-3][0-9]", message = "Формат даты: гггг-ММ-дд")
    private String birthDate;

    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", message = "Формат телефонного номера: +7(xxx)xxx-xx-xx")
    private String telephone;

    @Email(message = "Некорректный адрес eMail")
    private String email;
}
