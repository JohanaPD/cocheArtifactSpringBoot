package com.project_coche.domain.service;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.useCase.ICardService;
import com.project_coche.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    @Autowired
    private final CardRepository cardRepository;


    @Override
    public List<CardDto> getAll() {
        return cardRepository.getAll();
    }

    @Override
    public Optional<CardDto> getById(int id) {
        return cardRepository.getById(id);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer id) {
        return List.of();
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(Double price) {
        return List.of();
    }

    @Override
    public CardDto save(CardDto cardDto) {
        return cardRepository.save(cardDto);
    }

    @Override
    public Optional<CardDto> update(CardDto cardDto) {
        if (cardRepository.getById(cardDto.getId_vehiculo()).isEmpty()) {
            return Optional.empty();
        }
        return Optional
                .of(cardRepository
                        .save(cardDto));
    }

    @Override
    public boolean delete(Integer idCard) {
        if (cardRepository
                .getById(idCard)
                .isEmpty()) {
            return false;
        }
        cardRepository.delete(idCard);
        return false;

    }
}
