package stepik.contactsApp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class CreateContactOwnerDTO {
    @NotBlank(message = "Имя пользователя обязательно")
    @Size(min = 6, max = 20, message = "Длина имени д.б. от 6 до 20 символов")
    private String username;

    private String description;

    @Email(message = "Некорректный eMail")
    @NotBlank(message = "Значение eMail обязательно")
    private String email;

    @NotBlank(message = "Пароль обязателен")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Z,a-z,0-9]{8,}$",
            message = "Пароль должен содержать минимум 6 символов, включая заглавные латинские буквы и цифры")
    private String password;

    @Size(message = "Полное имя должно содержать от 2 до 50 символов")
    private String fullName;
}
