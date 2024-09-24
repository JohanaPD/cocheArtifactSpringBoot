package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.PurchaseRequestDto;
import com.project_coche.persistence.entities.CustomerEntity;
import com.project_coche.persistence.entities.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toCustomersDtoList(List<PurchaseEntity> purchaseEntities);
}
