package com.project_coche.persistence.repository;

import com.project_coche.domain.dto.BrandCardDto;
import com.project_coche.domain.repository.IBrandCardRepository;
import com.project_coche.persistence.crud.IBrandCardCRUDRepository;
import com.project_coche.persistence.entities.BrandCardEntity;
import com.project_coche.persistence.mapper.IBrandCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BrandCardRepository implements IBrandCardRepository {

    private final IBrandCardCRUDRepository iBrandCardCRUDRepository;
    private final IBrandCardMapper iBrandCardMapper;

    @Override
    public List<BrandCardDto> getAll() {
        return iBrandCardMapper.toBrandsCardsDto(iBrandCardCRUDRepository.findAll());
    }

    @Override
    public Optional<BrandCardDto> getById(int id) {
        return iBrandCardCRUDRepository.findById(id)
                // .map(marcaCocheEntity -> iBrandCardMapper.toBrandCardPojo(marcaCocheEntity));
                .map(iBrandCardMapper::toBrandCardDto);
    }

    @Override
    public BrandCardDto save(BrandCardDto brandCardDto) {
        BrandCardEntity brandCardEntity = iBrandCardMapper.toBrandcardEntity(brandCardDto);
        return iBrandCardMapper.toBrandCardDto(iBrandCardCRUDRepository.save(brandCardEntity));
    }

    @Override
    public void delete(Integer idBrandCard) {
        iBrandCardCRUDRepository.deleteById(idBrandCard);
    }
}
