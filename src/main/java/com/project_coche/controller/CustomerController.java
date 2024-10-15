package com.project_coche.controller;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.dto.ResponseCustomerDto;
import com.project_coche.domain.useCase.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") String id) {
        return ResponseEntity.of(customerService.getCustomerByCardId(id));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable("email") String email) {
        return ResponseEntity.of(customerService.getCustomerByemail(email));
    }

    @PostMapping()
    public ResponseEntity<ResponseCustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(customerService.save(customerDto));
    }

    @PatchMapping()
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.of(customerService.update(customerDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable String id) {
        return new ResponseEntity<>(this.customerService.delete(id)? HttpStatus.OK : HttpStatus.NOT_FOUND );
    }
}
