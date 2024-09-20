package com.project_coche.domain.useCase;

import com.project_coche.domain.dto.BrandCardDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCardService {
    List<BrandCardDto> getAll();

    Optional<BrandCardDto> getById(int id);

    BrandCardDto save(BrandCardDto brandCardDto);

    Optional<BrandCardDto> update(BrandCardDto brandCardDto);

    boolean delete(Integer idBrandCard);
}
