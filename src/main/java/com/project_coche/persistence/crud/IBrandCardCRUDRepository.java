package com.project_coche.persistence.crud;

import com.project_coche.persistence.entities.BrandCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCardCRUDRepository extends JpaRepository<BrandCardEntity, Integer> {



}
