package ru.ksergey.contactApp.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactDto {
    // TODO
    @NotNull(message = "ID обязателен")
    private Integer id;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёË]{2,}$", message = "Имя должно содержать только буквы")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустым")
    @Size(min = 2, max = 50, message = "Фамилия должна быть от 2 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёË]{2,}$", message = "Фамилия должна содержать только буквы")
    private String lastName;

    @NotBlank(message = "Телефон обязателен")
    @Pattern(regexp = "\\+7\\(\\d{3}\\)\\d{3} \\d{2} \\d{2}", message = "Неверный формат телефона")
    private String telephone;

    @NotBlank(message = "Email обязателен")
    @Email(message = "Некорректный email")
    private String email;

    private ContactDetailDto contactDetail;

    @NotEmpty(message = "ID владельца не может быть пустым")
    private String ownerId;
}
