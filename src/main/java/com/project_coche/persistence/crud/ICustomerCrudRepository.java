package com.project_coche.persistence.crud;

import com.project_coche.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByEmail(String email);
}
