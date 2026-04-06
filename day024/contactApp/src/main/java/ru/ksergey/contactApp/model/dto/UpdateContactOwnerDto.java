package ru.ksergey.contactApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateContactOwnerDto {
    @NotBlank(message = "ID обязателен")
    private String id;

    @Size(min = 6, max = 20,
            message = "Имя пользователя должно быть от 6 до 20 символов")
    private String username;

    @NotNull(message = "Значение null недопустимо")
    private String description;

    @NotBlank(message = "Поле не может быть пустым")
    @Email(message = "Некорректный email")
    private String email;

}
