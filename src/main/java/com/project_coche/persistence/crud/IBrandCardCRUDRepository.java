package com.project_coche.persistence.crud;

import com.project_coche.persistence.entities.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCardCRUDRepository extends JpaRepository<BrandCarEntity, Integer> {



}
