package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateCustomerDTO;
import com.resul.ecommerce.dto.CustomerDTO;
import com.resul.ecommerce.dto.UpdateCustomerDTO;
import com.resul.ecommerce.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toCustomerEntity(CreateCustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(CustomerEntity customerEntity);
    List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntities);

    void toCustomerEntity(UpdateCustomerDTO updateCustomerDTO, @MappingTarget CustomerEntity customerEntity);
}
