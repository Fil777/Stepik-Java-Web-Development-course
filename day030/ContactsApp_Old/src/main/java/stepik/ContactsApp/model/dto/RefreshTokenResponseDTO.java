package stepik.contactsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponseDTO {
    // DTO для ответа с JWT токеном и refresh токеном
    private String jwtToken;
    private String refreshToken;
}
