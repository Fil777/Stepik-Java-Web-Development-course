package stepik.ContactsApp.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import stepik.ContactsApp.model.entity.ContactOwner;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtSecurityService {

    // секретный ключ для подписи JWT токенов (см. конфигурацию в application.properties)
    @Value("${jwt.secret-key}")
    private String secretKey;

    // метод для получения (расшифровки) секретного ключа (см. конфигурацию в application.properties)
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // метод для генерации токенов
    public String generateToken(UserDetails userDetails) {
        ContactOwner co = (ContactOwner) userDetails;
        return Jwts.builder()
                .subject(co.getEmail())
                .claim("ownerId", co.getId())
                .claim("role", co.getAuthorities().stream()
                        .findFirst()
                        .map(GrantedAuthority::getAuthority)
                        .orElse("USER"))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // это 60 минут!
                .signWith(getSigningKey())
                .compact();
    }

    // метод для генерации refresh-токенов (реакция на бездействие в программе)
    public String generateRefreshToken(Map<String, String> claims, UserDetails userDetails) {
        ContactOwner co = (ContactOwner) userDetails;
        return Jwts.builder()
                .claims(claims)
                .subject(co.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 7 дней!
                .signWith(getSigningKey())
                .compact();
    }

    // метод для извлечения конкретного claim (данных) из JWT токена
    // на входе - токен и функция, которая будет использоваться для извлечения claim,
    // на выходе - значение claim
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // метод для извлечения всех claims (данных) из JWT токена
    // на входе - токен, на выходе - claims (данные)
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // методы для извлечения конкретных claims (данных) из JWT токена
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // у нас в subject хранится email пользователя
        // мы решили для аутентификации использовать email, а не username
    }

    // метод для получения времени истечения токена (для проверки валидности)
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // метод для получения времени создания токена (для проверки валидности)
    public Date extractIssuedAt(String token) {
        return extractClaim(token, Claims::getIssuedAt);
    }

    // метод для проверки валидности токена по времени истечения
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // метод для проверки валидности токена
    // проверяем, что пользователь, выдавший запрос, имеет именно ту почту, которая хранится в токене
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }
}