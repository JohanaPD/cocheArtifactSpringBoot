package com.project_coche.domain.service;

import com.project_coche.domain.dto.AuthCustomerDto;
import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.dto.JwtResponseDto;
import com.project_coche.domain.repository.ICustomerRepository;
import com.project_coche.domain.useCase.IAuthUseCase;
import com.project_coche.exceptions.CustomerNotExistException;
import com.project_coche.exceptions.PasswordIncorrectException;
import com.project_coche.security.JwAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthUseCase {

    private final ICustomerRepository iCustomerRepository;
    private final JwAuthenticationProvider jwAuthenticationProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) throws CustomerNotExistException, PasswordIncorrectException {

        Optional<CustomerDto> customerDto = iCustomerRepository.getCustomerByemail(authCustomerDto.getEmail());

        if (customerDto.isEmpty()) {
            throw new CustomerNotExistException();
        }
        if (authCustomerDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (!passwordEncoder.matches(authCustomerDto.getPassword(), customerDto.get().getPassword())) {
            throw new PasswordIncorrectException();
        }
        return new JwtResponseDto((String) jwAuthenticationProvider.createToken(customerDto.get()));
    }

    @Override
    public JwtResponseDto signOut(String jwt) {
        return null;
    }
}
