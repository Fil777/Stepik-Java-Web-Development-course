package ru.ksergey.contactApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactDto {
    @NotEmpty(message = "Имя не может быть пустым")
    private String firstName;
    @NotEmpty(message = "Фамилия не может быть пустым")
    private String lastName;
    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3} \\d{2} \\d{2}",
            message = "Неверный формат телефона")
    private String telephone;
    @Email(message = "Некорректный email")
    private String email;

    private ContactDetailDto contactDetail;

    @NotEmpty(message = "ID владельца не может быть пустым")
    private String ownerId;
}
