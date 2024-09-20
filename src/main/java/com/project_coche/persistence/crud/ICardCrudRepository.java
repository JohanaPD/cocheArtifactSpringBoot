package com.project_coche.persistence.crud;

import com.project_coche.persistence.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICardCrudRepository extends JpaRepository<CardEntity, Integer> {

    List<CardEntity> findAllByBrandCardId(Integer id);

    List<CardEntity> findAllbyPriceLessThan(Double price);
}
