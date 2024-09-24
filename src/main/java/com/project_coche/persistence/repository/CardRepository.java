package com.project_coche.persistence.repository;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.repository.ICardRepository;

import com.project_coche.persistence.crud.ICardCrudRepository;
import com.project_coche.persistence.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CardRepository implements ICardRepository {

    private final ICardCrudRepository iCardCrudRepository;

    private final ICarMapper iCarMapper;

    @Override
    public List<CardDto> getAll() {

        return iCarMapper
                .toCardDtoList(iCardCrudRepository
                        .findAll());
    }

    @Override
    public Optional<CardDto> getById(Integer id) {
        return iCardCrudRepository
                .findById(id)
                .map(iCarMapper::toCardDto);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer id) {
        return iCarMapper
                .toCardDtoList(iCardCrudRepository
                        .findAllBybrandCardId(id));
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(double price) {

        return iCarMapper.toCardDtoList(iCardCrudRepository.findAllByPriceLessThan(price));
    }

    @Override
    public CardDto save(CardDto brandCardDto) {
        return iCarMapper
                .toCardDto(iCardCrudRepository
                        .save(iCarMapper
                                .toCardEntity(brandCardDto)));
    }

    @Override
    public void delete(Integer idCard) {

        iCardCrudRepository
                .deleteById(idCard);
    }
}
