package com.project_coche.persistence.mapper;

import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.persistence.entities.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList);

}
