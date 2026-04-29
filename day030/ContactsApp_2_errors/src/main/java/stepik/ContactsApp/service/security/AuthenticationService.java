package stepik.ContactsApp.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stepik.ContactsApp.dao.JpaContactOwnerRepositoryAdapter;
import stepik.ContactsApp.model.entity.ContactOwner;
import stepik.ContactsApp.model.enums.AppRole;
import stepik.ContactsApp.model.dto.LoginRequestDTO;
import stepik.ContactsApp.model.dto.LoginResponseDTO;
import stepik.ContactsApp.model.dto.RegisterRequestDTO;
import stepik.ContactsApp.model.dto.RefreshTokenRequestDTO;
import stepik.ContactsApp.model.dto.RefreshTokenResponseDTO;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JpaContactOwnerRepositoryAdapter contactOwnerRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtSecurityService jwtSecurityService;
    private final AuthenticationManager authenticationManager;

    // Метод для регистрации и сохранения нового пользователя
    public ContactOwner register(RegisterRequestDTO registerRequestDTO) {
        // Создание нового пользователя с хешированным паролем и ролью USER
        ContactOwner appUser = new ContactOwner();
        appUser.setUsername(registerRequestDTO.getUsername());
        appUser.setEmail(registerRequestDTO.getEmail());
        appUser.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        appUser.setRole(AppRole.USER);

        return contactOwnerRepository.save(appUser);
    }

    // Метод логирования и генерации токена и refresh tokenа
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        // Аутентификация пользователя и генерация токена и refresh tokenа
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()));

        // Получение данных пользователя из репозитория
        ContactOwner user = contactOwnerRepository
                .findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Ошибка"));

        //
        String token = jwtSecurityService.generateToken(user);
        String refreshToken = jwtSecurityService
                .generateRefreshToken(new HashMap<>(), user);

        // Возврат токена и refresh tokena
        return LoginResponseDTO
                .builder()
                .email(loginRequestDTO.getEmail())
                .jwtToken(token)
                .refreshToken(refreshToken)
                .build();
    }

    //
    public RefreshTokenResponseDTO refresh(RefreshTokenRequestDTO refreshTokenRequestDTO) {
        String jwt = refreshTokenRequestDTO.getRefreshToken();
        String email = jwtSecurityService.extractUsername(jwt); // Извлечение email=username из токена
        ContactOwner user = contactOwnerRepository // Поиск пользователя по email в репозитории
                .findByEmail(email)
                .orElseThrow();

        if (jwtSecurityService.validateToken(jwt, user)) {
            // Проверка токена и генерация новых токенов
            RefreshTokenResponseDTO refreshTokenResponseDTO = new RefreshTokenResponseDTO();
            // Генерация новых токенов
            refreshTokenResponseDTO
                    .setJwtToken(jwtSecurityService.generateToken(user));
            // Генерация нового refresh tokena
            refreshTokenResponseDTO
                    .setRefreshToken(jwtSecurityService.generateRefreshToken(new HashMap<>(), user));
            // Возврат новых токенов
            return refreshTokenResponseDTO;
        }

        return null;
    }
}
