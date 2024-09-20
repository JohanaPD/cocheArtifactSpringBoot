package com.project_coche.domain.service;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.repository.ICardRepository;
import com.project_coche.domain.useCase.ICardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final ICardRepository iCardRepository;


    @Override
    public List<CardDto> getAll() {
        return iCardRepository.getAll();
    }

    @Override
    public Optional<CardDto> getById(int id) {
        return iCardRepository.getById(id);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer id) {
        return iCardRepository
                .getByIdBrandCard(id);
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(Double price) {
        return iCardRepository
                .getCardsByPriceLessThan(price);
    }

    @Override
    public CardDto save(CardDto cardDto) {
        return iCardRepository.save(cardDto);
    }

    @Override
    public Optional<CardDto> update(CardDto cardDto) {
        if (iCardRepository
                .getById(cardDto
                        .getId_vehiculo())
                .isEmpty()) {
            return Optional.empty();
        }
        return Optional
                .of(iCardRepository
                        .save(cardDto));
    }

    @Override
    public boolean delete(Integer idCard) {
        if (iCardRepository
                .getById(idCard)
                .isEmpty()) {
            return false;
        }
        iCardRepository.delete(idCard);
        return true;

    }
}
