package com.project_coche.persistence.repository;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.repository.ICardRepository;

import com.project_coche.persistence.crud.ICardCrudRepository;
import com.project_coche.persistence.entities.CardEntity;
import com.project_coche.persistence.mapper.ICardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CardRepository implements ICardRepository {

    private final ICardCrudRepository iCardCrudRepository;

    private final ICardMapper iCardMapper;

    @Override
    public List<CardDto> getAll() {

        return iCardMapper
                .toCardDtoList(iCardCrudRepository
                        .findAll());
    }

    @Override
    public Optional<CardDto> getById(Integer id) {
        return iCardCrudRepository
                .findById(id)
                .map(iCardMapper::toCardDto);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer id) {
        return iCardMapper
                .toCardDtoList(iCardCrudRepository
                        .findAllByBrandCardId(id));
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(Double price) {

        return iCardMapper.toCardDtoList(iCardCrudRepository.findAllbyPriceLessThan(price));
    }

    @Override
    public CardDto save(CardDto brandCardDto) {
        return iCardMapper
                .toCardDto(iCardCrudRepository
                        .save(iCardMapper
                                .toCardEntity(brandCardDto)));
    }

    @Override
    public void delete(Integer idCard) {

        iCardCrudRepository
                .deleteById(idCard);
    }
}
