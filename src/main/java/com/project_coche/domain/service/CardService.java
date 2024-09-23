package com.project_coche.domain.service;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.repository.ICardRepository;
import com.project_coche.domain.useCase.ICardService;
import com.project_coche.persistence.entities.CardEntity;
import com.project_coche.persistence.mapper.ICardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final ICardRepository iCardRepository;
    private final ICardMapper icardMapper;


    @Override
    public List<CardDto> getAll() {
        return iCardRepository.getAll();
    }

    @Override
    public Optional<CardDto> getById(Integer id) {
        return iCardRepository.getById(id);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer idBrandCard) {
        return iCardRepository
                .getByIdBrandCard(idBrandCard);
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(double price) {
        return iCardRepository
                .getCardsByPriceLessThan(price);
    }

    @Override
    public CardDto save(CardDto cardDto) {
        CardEntity cardEntity =icardMapper.toCardEntity(cardDto) ;
        System.out.println("Price a persistir: " + cardEntity.getPrice());
        return iCardRepository
                .save(cardDto);
    }

    @Override
    public Optional<CardDto> update(CardDto cardDto) {
        System.out.println(cardDto.getId_vehiculo());
        if (cardDto.getId_vehiculo() == null) {
            throw new IllegalArgumentException("El ID del vehículo no puede ser nulo");
        }
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
