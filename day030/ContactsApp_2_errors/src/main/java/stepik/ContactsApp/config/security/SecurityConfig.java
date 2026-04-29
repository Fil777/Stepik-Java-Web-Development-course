package stepik.ContactsApp.config.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import stepik.ContactsApp.model.enums.AppRole;
import stepik.ContactsApp.service.contacts.ContactOwnerService;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final stepik.ContactsApp.config.security.JwtAuthenticationFilter authenticationFilter;
    private final ContactOwnerService contactOwnerService;

    // секретный ключ для jwt токена
    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    @Bean
    // декодер для пароля
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // авторизация для jwt токена
    // логика для проверки пользователя и пароля, а также для генерации jwt токена
    public AuthenticationProvider authProvider() {
        // создаем провайдера для аутентификации и устанавливаем детали пользователя и кодировщик пароля
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(contactOwnerService.getUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    // создание менеджера аутентификации
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        // проверка учётных данных и возврат аутентифицированного менеджера для входа в в систему
        return config.getAuthenticationManager();
    }

    @Bean
    // декодер для jwt токена
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder
                .withSecretKey(secretKey())
                .build();
    }

    // создание секретного ключа для jwt токена
    private SecretKey secretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    @Bean
    // создание конвертера для извлечения прав доступа из jwt токена
    // будет использоваться роль пользователя в качестве привилегии
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
        authoritiesConverter.setAuthoritiesClaimName("role");
        // стандартный префикс для ролей, который будет добавлен к каждой роли в jwt токене
        // по умолчанию префикс - "ROLE_", а у нас роли просто "USER" или "ADMIN" без префикса
        authoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
        return converter;
    }

    @Bean
    // создание цепочки фильтров для безопасности
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // отключаем csrf защиту
                .cors(Customizer.withDefaults()) // включаем cors защиту
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())) // включаем защиту от oauth2 ресурсов
                .authorizeHttpRequests(req -> req
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html") // включаем доступ к api и документации для swagger
                        .permitAll() //
                        .requestMatchers("/api/contact/**").hasAuthority(AppRole.USER.name()) // доступ к api контактов для пользователей с ролью USER
                        .requestMatchers("/api/owner/**").hasAuthority(AppRole.ADMIN.name())  // доступ к api владельцев контактов для пользователей с ролью ADMIN
                        .anyRequest().authenticated()) // остальные запросы требуют аутентификации
                .sessionManagement(m -> m.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // отключаем управление сессиями
                .authenticationProvider(authProvider()) // добавляем провайдера для аутентификации
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class) // добавляем кастомный фильтр аутентификации
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> response
                                .sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))); // обработка исключений аутентификации

        return httpSecurity.build(); // возврат настроенной цепочки фильтров для безопасности
    }
}

