package com.project_coche.domain.repository;

import com.project_coche.domain.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface ICardRepository {
    List<CardDto> getAll();

    Optional<CardDto> getById(Integer id);

    List<CardDto> getByIdBrandCard(Integer id);

    List<CardDto> getCardsByPriceLessThan(Double price);

    CardDto save(CardDto cardDto);

    void delete(Integer idCard);
}
