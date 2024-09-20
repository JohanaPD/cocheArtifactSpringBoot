package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.BrandCardDto;
import com.project_coche.persistence.entities.BrandCardEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandCardMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description" , target = "description")
    BrandCardDto toBrandCardDto(BrandCardEntity brandCardEntity);

    @InheritInverseConfiguration
    @Mapping(target = "cardEntities", ignore = true)
    BrandCardEntity toBrandcardEntity(BrandCardDto brandCardDto) ;

    List<BrandCardDto> toBrandsCardsDto(List<BrandCardEntity> marcasCocheentities);
    List<BrandCardEntity> toBrandsCardsEntities(List<BrandCardDto> marcasCochepojos);

}
