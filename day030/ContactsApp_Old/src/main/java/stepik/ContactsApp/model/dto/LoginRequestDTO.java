package stepik.contactsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    // DTO для авторизации
    private String email;
    private String password;
}
