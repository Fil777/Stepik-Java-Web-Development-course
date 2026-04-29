package stepik.ContactsApp.config.security;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import stepik.ContactsApp.service.contacts.ContactOwnerService;
import stepik.ContactsApp.service.security.JwtSecurityService;

import java.io.IOException;

/**
* JwtAuthenticationFilter - это фильтр, который проверяет наличие токена JWT в заголовке Authorization
* запроса и аутентифицирует пользователя, если токен валиден.
* Если токен отсутствует, то запрос пропускается дальше без аутентификации.
* Если токен валиден, то создается новая сессия для аутентифицированного пользователя.
* Если токен не валиден, запрос пропускается дальше без аутентификации.
*/

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtSecurityService jwtSecurityService;
    private final ContactOwnerService contactOwnerService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        // если токен отсутствует или не начинается с Bearer, пропускаем запрос
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return; // вылет без аутентификации
        }

        // получение токена из заголовка запроса
        String jwt = header.substring(7); // убираем "Bearer " из заголовка
        String email = jwtSecurityService.extractUsername(jwt);

        // если email есть в токене и аутентификации нет, то создаем новую сессию
        if (StringUtils.isNotEmpty(email)
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = contactOwnerService
                    .getUserDetailsService()
                    .loadUserByUsername(email);

            // если токен валиден, то устанавливаем аутентификацию
            if (jwtSecurityService.validateToken(jwt, userDetails)) {
                // создание пустого контекста безопасности
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

                // создание токена аутентификации и установка его в контекст безопасности
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // установка дополнительных деталей о запросе в токен аутентификации
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);
            }
        }
        // пропуск запроса дальше в цепочку фильтров
        filterChain.doFilter(request, response);
    }
}
