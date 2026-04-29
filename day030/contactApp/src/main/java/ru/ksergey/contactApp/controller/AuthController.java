package ru.ksergey.contactApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksergey.contactApp.common.util.ServerResponseHelper;
import ru.ksergey.contactApp.model.ServerResponse;
import ru.ksergey.contactApp.model.dto.*;
import ru.ksergey.contactApp.model.entity.ContactOwner;
import ru.ksergey.contactApp.service.security.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ServerResponse<ContactOwner>> register(
            @RequestBody RegisterRequestDto registerRequestDto) {
        return ServerResponseHelper.ok(authService.register(registerRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<ServerResponse<LoginResponseDto>> login(
            @RequestBody LoginRequestDto loginRequestDto) {
        return ServerResponseHelper.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ServerResponse<RefreshTokenResponseDto>> refresh(
            @RequestBody RefreshTokenRequestDto refreshTokenRequestDto) {
        return ServerResponseHelper.ok(authService.refresh(refreshTokenRequestDto));
    }
}
