package com.project_coche.config;

import com.project_coche.security.JwAuthFilter;
import com.project_coche.security.JwAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class AplicationConfig {
    private final JwAuthenticationProvider jwAuthenticationProvider;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwAuthFilter jwAuthFilter(){
        return new JwAuthFilter(jwAuthenticationProvider);
    }
}
