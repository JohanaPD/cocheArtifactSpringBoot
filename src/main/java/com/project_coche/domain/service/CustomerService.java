package com.project_coche.domain.service;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.dto.ResponseCustomerDto;
import com.project_coche.domain.repository.ICustomerRepository;
import com.project_coche.domain.useCase.ICustomerService;
import com.project_coche.exceptions.EmailValidationException;
import com.project_coche.security.Roles;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
   // private final BCryptPasswordEncoder passwordEncoder; // Inyectar el codificador

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return customerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByemail(String email) {
        return customerRepository.getCustomerByemail(email);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if (customerRepository.getCustomerByCardId(customerDto.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(customerRepository.save(customerDto));
    }

    @Override
    public ResponseCustomerDto save(CustomerDto customerDto) {

        if (!customerDto.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            throw new EmailValidationException();
        }
        String password = generatePassword(8);
       // customerDto.setPassword(passwordEncoder.encode(password));// revisa esto
        customerDto.setPassword(password);
        customerDto.setActive(1);
        customerDto.setRol(Roles.CUSTOMER);
        customerRepository.save(customerDto);
        return new ResponseCustomerDto(password);
    }

    @Override
    public boolean delete(String idCustomerDto) {
        if (customerRepository.getCustomerByCardId(idCustomerDto).isEmpty()) {
            return false;
        }
        customerRepository.delete(idCustomerDto);
        return true;
    }

    private String generatePassword(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
