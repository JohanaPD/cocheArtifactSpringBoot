package com.project_coche.security;

import com.project_coche.exceptions.UnauthorizadException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwAuthFilter extends OncePerRequestFilter {

    private final JwAuthenticationProvider jwAuthenticationProvider;

    private List<String> urlsToSkip = List.of("/auth", "/swagger-ui.html", "/swagger-ui", "api/docs", "/api/customers");


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return urlsToSkip.stream().anyMatch(url -> request.getRequestURI().startsWith(url));
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        System.out.println(header);

        if (header == null || !header.startsWith("Bearer ")) {
            throw new UnauthorizadException();
        }

        String token = header.substring(7);

       /* String[] authElements = header.split(" ");
        if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
            throw new UnauthorizadException();
        }
        // String token = authElements[1].trim();

        if (token.split("\\.").length != 3) {
            throw new UnauthorizadException();
        }*/
        try {
            Authentication authetication = jwAuthenticationProvider.validateToken(token);
            SecurityContextHolder.getContext().setAuthentication(authetication);
        } catch (RuntimeException e) {
            SecurityContextHolder.clearContext();
        }
        // Permite que el resto del filtro se ejecute
        filterChain.doFilter(request, response);

    }
}
