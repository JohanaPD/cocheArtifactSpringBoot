package com.project_coche.persistence.repository;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.repository.ICustomerRepository;
import com.project_coche.persistence.crud.ICustomerCrudRepository;
import com.project_coche.persistence.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository customerRepository;
    private final ICustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return customerMapper.toCustomerDtoList(customerRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return customerRepository.findById(cardId).map(customerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByemail(String email) {
        return customerRepository.findByEmail(email).map(customerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerMapper
                .toCustomerDto(customerRepository.save(customerMapper.toCustomerEntity(customerDto)));
    }

    @Override
    public void delete(String idCustomerDto) {
        customerRepository.deleteById(idCustomerDto);
    }
}
