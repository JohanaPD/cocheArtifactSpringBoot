package com.project_coche.domain.repository;

import com.project_coche.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByemail(String email);

    //Optional<CustomerDto> update(CustomerDto customerDto);

    CustomerDto save(CustomerDto customerDto);

    void delete(String idCustomerDto);
}
