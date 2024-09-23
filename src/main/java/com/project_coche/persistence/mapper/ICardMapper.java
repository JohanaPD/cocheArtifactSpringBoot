package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.persistence.entities.CardEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ICardMapper {
    @Mapping(source = "cardId", target = "id_vehiculo")
    @Mapping(source = "price", target = "price")
    CardDto toCardDto(CardEntity cardEntity);


    @Mapping(target = "brandCardEntity", ignore = true)
    @Mapping(source = "price", target = "price")
    @InheritInverseConfiguration
    CardEntity toCardEntity(CardDto cardDto);

    List<CardDto> toCardDtoList(List<CardEntity> cardEntities);

    List<CardEntity> toCardEntityList(List<CardDto> cardDtos);

}
