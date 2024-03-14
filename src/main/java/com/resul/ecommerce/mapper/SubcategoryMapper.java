package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateSubcategoryDTO;
import com.resul.ecommerce.dto.SubcategoryDTO;
import com.resul.ecommerce.dto.UpdateSubcategoryDTO;
import com.resul.ecommerce.repository.entity.SubcategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface SubcategoryMapper {
    List<SubcategoryDTO> toSubategoryDTOList(List<SubcategoryEntity> subcategoryEntities);
    SubcategoryEntity toSubcategoryEntity(CreateSubcategoryDTO createSubcategoryDTO);
    SubcategoryDTO toSubcategoryDTO(SubcategoryEntity subcategoryEntity);

    void toSubcategoryEntity(UpdateSubcategoryDTO updateSubcategoryDTO, @MappingTarget SubcategoryEntity subcategoryEntity);
}
