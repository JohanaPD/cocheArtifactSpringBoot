package com.project_coche.persistence.crud;

import com.project_coche.persistence.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICardCrudRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllBybrandCardId(Integer id);

    List<CarEntity> findAllByPriceLessThan(double precio);
}
