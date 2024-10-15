package com.project_coche.config;

import com.project_coche.exceptions.AccessDeniedHandlerException;
import com.project_coche.security.JwAuthFilter;
import com.project_coche.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final AccessDeniedHandlerException accessDeniedHandlerException;
    private final JwAuthFilter jwAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling.accessDeniedHandler(accessDeniedHandlerException)
                )
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF usando la nueva API
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/auth/**", "swagger-ui.html", "swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/customers").permitAll()
                                //Puedo añadir varios roles
                                .requestMatchers("/cars").hasAnyRole(Roles.ADMMIN, Roles.CUSTOMER)
                              //  .requestMatchers("/cars").hasRole(Roles.CUSTOMER)
                               // .requestMatchers("/cars").hasAuthority("prueba")
                                /*.requestMatchers("/cars").hasAuthority("WRITE_PRIVILEGE")
                                .requestMatchers("/cars").hasRole(Roles.CUSTOMER)*/
                                .anyRequest().authenticated()
                );

        return http.build();
    }


}
