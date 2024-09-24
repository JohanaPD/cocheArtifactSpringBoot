package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.persistence.entities.CarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ICarMapper {
    @Mapping(source = "cardId", target = "id_vehiculo")
    @Mapping(source = "price", target = "price")
    CardDto toCardDto(CarEntity carEntity);


    @Mapping(target = "brandCarEntity", ignore = true)
    @Mapping(target = "purchaseCarEntity", ignore = true)
    @Mapping(source = "price", target = "price")
    @InheritInverseConfiguration
    CarEntity toCardEntity(CardDto cardDto);

    List<CardDto> toCardDtoList(List<CarEntity> cardEntities);

    List<CarEntity> toCardEntityList(List<CardDto> cardDtos);

}
