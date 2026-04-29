package stepik.ContactsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stepik.ContactsApp.common.utils.serverresponse.ServerResponseHelper;
import stepik.ContactsApp.model.ServerResponse;
import stepik.ContactsApp.model.dto.*;
import stepik.ContactsApp.model.entity.ContactOwner;
import stepik.ContactsApp.service.security.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
// Контроллер для аутентификации и авторизации пользователей.
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    // Метод регистрации нового пользователя.
    public ResponseEntity<ServerResponse<ContactOwner>> register(
            @RequestBody RegisterRequestDTO registerRequestDTO) {
        return ServerResponseHelper.ok(authService.register(registerRequestDTO));
    }

    @PostMapping("/login")
    // Метод аутентификации пользователя.
    public ResponseEntity<ServerResponse<LoginResponseDTO>> login(
            @RequestBody LoginRequestDTO loginRequestDTO) {
        return ServerResponseHelper.ok(authService.login(loginRequestDTO));
    }

    // Метод для обновления токена доступа.
    @PostMapping("/refresh")
    public ResponseEntity<ServerResponse<RefreshTokenResponseDTO>> refresh(
            @RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return ServerResponseHelper.ok(authService.refresh(refreshTokenRequestDTO));
    }
}
