package stepik.ContactsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    // DTO для регистрации пользователя
    private String username;
    private String email;
    private String password;
}
