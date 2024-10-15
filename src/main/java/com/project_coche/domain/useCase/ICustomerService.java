package com.project_coche.domain.useCase;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.dto.ResponseCustomerDto;
import com.project_coche.exceptions.EmailValidationException;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByemail(String email);

    Optional<CustomerDto> update(CustomerDto customerDto);

    ResponseCustomerDto save(CustomerDto customerDto) throws EmailValidationException;

    boolean delete(String idCustomerDto);

}
