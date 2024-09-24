package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.persistence.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    @Mapping(target = "purchaseEntity", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList);

}
