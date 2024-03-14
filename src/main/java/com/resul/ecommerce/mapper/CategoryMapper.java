package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CategoryDTO;
import com.resul.ecommerce.dto.CreateCategoryDTO;
import com.resul.ecommerce.dto.UpdateCategoryDTO;
import com.resul.ecommerce.repository.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryDTO> toCategoryDTOList(List<CategoryEntity> categoryEntities);
    CategoryEntity toCategoryEntity(CreateCategoryDTO createCategoryDTO);
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);

    void toCategoryEntity(UpdateCategoryDTO updateCategoryDTO, @MappingTarget CategoryEntity categoryEntity);
}
