package com.project_coche.domain.useCase;

import com.project_coche.domain.dto.AuthCustomerDto;
import com.project_coche.domain.dto.JwtResponseDto;
import com.project_coche.exceptions.CustomerNotExistException;
import com.project_coche.exceptions.PasswordIncorrectException;

public interface IAuthUseCase {
    JwtResponseDto signIn(AuthCustomerDto authCustomerDto) throws CustomerNotExistException, PasswordIncorrectException;

    JwtResponseDto signOut(String jwt);
}
