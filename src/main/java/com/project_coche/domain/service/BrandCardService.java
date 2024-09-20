package com.project_coche.domain.service;

import com.project_coche.domain.dto.BrandCardDto;
import com.project_coche.domain.repository.IBrandCardRepository;
import com.project_coche.domain.useCase.IBrandCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandCardService implements IBrandCardService {

    @Autowired
    private IBrandCardRepository brandCardRepository;

    @Override
    public List<BrandCardDto> getAll() {

        return brandCardRepository.getAll();
    }

    @Override
    public Optional<BrandCardDto> getById(int id) {

        return brandCardRepository.getById(id);
    }

    @Override
    public BrandCardDto save(BrandCardDto brandCardDto) {
        return brandCardRepository.save(brandCardDto);
    }

    @Override
    public Optional<BrandCardDto> update(BrandCardDto brandCardDto) {
        if (brandCardRepository.getById(brandCardDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(brandCardRepository.save(brandCardDto));
    }

    @Override
    public boolean delete(Integer idBrandCard) {
        if (brandCardRepository.getById(idBrandCard).isEmpty()) {
            return false;
        }
        brandCardRepository.delete(idBrandCard);
        return true;
    }
}
