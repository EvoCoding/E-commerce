package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.*;
import com.resul.ecommerce.repository.entity.CustomerEntity;
import com.resul.ecommerce.repository.entity.StoreEntity;
import com.resul.ecommerce.vo.FindProductsVo;
import com.resul.ecommerce.vo.FindStoresVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreEntity toStoreEntity(CreateStoreDTO storeDTO);
    CustomerDTO toCustomerDTO(CustomerEntity customerEntity);
    List<StoreDTO> toStoreDTOList(Page<StoreEntity> storeEntities);

    StoreDTO toStoreDTO(StoreEntity storeEntity);

    void toStoreEntity(UpdateStoreDTO updateStoreDTO, @MappingTarget StoreEntity storeEntity);

    @Mapping(target = "namePhrase", expression = "java(trimToNull(findStoresDTO.getNamePhrase()))")
    FindStoresVo toFindStoreVo(FindStoresDTO findStoresDTO);

    default String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
