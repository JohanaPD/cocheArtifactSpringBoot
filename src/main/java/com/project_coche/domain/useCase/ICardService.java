package com.project_coche.domain.useCase;

import com.project_coche.domain.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface ICardService {

    List<CardDto> getAll();

    Optional<CardDto> getById(Integer id);

    List<CardDto> getByIdBrandCard(Integer idBrandCard);

    List<CardDto> getCardsByPriceLessThan(double price);

    CardDto save(CardDto CardDto);

    Optional<CardDto> update(CardDto cardDto);

    boolean delete(Integer idCard);
}
