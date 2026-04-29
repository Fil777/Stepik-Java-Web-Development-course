package stepik.contactsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenRequestDTO {
    // DTO для запроса обновления токена
    private String refreshToken;
}

