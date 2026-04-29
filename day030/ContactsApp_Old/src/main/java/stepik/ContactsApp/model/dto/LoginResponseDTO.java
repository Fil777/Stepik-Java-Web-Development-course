package stepik.contactsApp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {
    // DTO для ответа на запрос логина
    private String email;
    private String jwtToken;
    private String refreshToken;
}
