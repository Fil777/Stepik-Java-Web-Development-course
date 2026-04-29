package ru.ksergey.contactApp.service.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ksergey.contactApp.dao.ContactOwnerRepository;
import ru.ksergey.contactApp.model.dto.*;
import ru.ksergey.contactApp.model.entity.ContactOwner;
import ru.ksergey.contactApp.model.enums.AppRole;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ContactOwnerRepository contactOwnerRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtSecurityService jwtSecurityService;
    private final AuthenticationManager authenticationManager;

    public ContactOwner register(RegisterRequestDto registerRequestDto) {
        ContactOwner appUser = new ContactOwner();
        appUser.setUsername(registerRequestDto.getUsername());
        appUser.setEmail(registerRequestDto.getEmail());
        appUser.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        appUser.setRole(AppRole.USER);

        return contactOwnerRepository.save(appUser);
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()));

        ContactOwner user = contactOwnerRepository
                .findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Ошибка"));

        String token = jwtSecurityService.generateToken(user);
        String refreshToken = jwtSecurityService
                .generateRefreshToken(new HashMap<>(), user);

        return LoginResponseDto
                .builder()
                .email(loginRequestDto.getEmail())
                .jwtToken(token)
                .refreshToken(refreshToken)
                .build();
    }

    public RefreshTokenResponseDto refresh(RefreshTokenRequestDto refreshTokenRequestDto) {
        String jwt = refreshTokenRequestDto.getRefreshToken();
        String email = jwtSecurityService.extractUsername(jwt);
        ContactOwner user = contactOwnerRepository
                .findByEmail(email)
                .orElseThrow();

        if (jwtSecurityService.validateToken(jwt, user)) {
            RefreshTokenResponseDto refreshTokenResponseDto = new RefreshTokenResponseDto();

            refreshTokenResponseDto
                    .setJwtToken(jwtSecurityService.generateToken(user));

            refreshTokenResponseDto
                    .setRefreshToken(jwtSecurityService.generateRefreshToken(new HashMap<>(), user));

            return refreshTokenResponseDto;
        }

        return null;
    }
}
