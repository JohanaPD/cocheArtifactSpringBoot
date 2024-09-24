package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.BrandCardDto;
import com.project_coche.persistence.entities.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandCardMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description" , target = "description")
    BrandCardDto toBrandCardDto(BrandCarEntity brandCarEntity);

    @InheritInverseConfiguration
    @Mapping(target = "cardEntities", ignore = true)
    BrandCarEntity toBrandcardEntity(BrandCardDto brandCardDto) ;

    List<BrandCardDto> toBrandsCardsDto(List<BrandCarEntity> marcasCocheentities);
    List<BrandCarEntity> toBrandsCardsEntities(List<BrandCardDto> marcasCochepojos);

}
