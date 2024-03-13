package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateProductDTO;
import com.resul.ecommerce.dto.FindProductsDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.UpdateProductDTO;
import com.resul.ecommerce.repository.entity.ProductEntity;
import com.resul.ecommerce.vo.FindProductsVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel= "spring")
public interface ProductMapper {
    List<ProductDTO> toProductDTOList(Page<ProductEntity> productEntities);

    @Mapping(target = "namePhrase", expression = "java(trimToNull(findProductDTO.getNamePhrase()))")
    @Mapping(target = "descriptionPhrase", expression = "java(trimToNull(findProductDTO.getdescriptionPhrase()))")
    FindProductsVo toFindProductsVo(FindProductsDTO findProductDTO);

    default String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }


    ProductDTO toProductDTO(ProductEntity product);

    ProductEntity toProductEntity(CreateProductDTO createProductDTO);

    void toProductEntity(UpdateProductDTO updateProductDTO, ProductEntity product);
}
