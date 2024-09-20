package com.project_coche.domain.repository;

import com.project_coche.domain.dto.BrandCardDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCardRepository {

    List<BrandCardDto> getAll();

    Optional<BrandCardDto> getById(int id);

    BrandCardDto save(BrandCardDto brandCardDto);

    void delete(Integer idBrandCard);
}
