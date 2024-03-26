package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateProductReviewDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.ProductReviewDTO;
import com.resul.ecommerce.dto.UpdateProductReviewDTO;
import com.resul.ecommerce.repository.entity.ProductReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductReviewMapper {
     List<ProductReviewDTO> toProductReviewsDTOList(List<ProductReviewEntity> productReviewEntities);

     ProductReviewEntity toProductReviewEntity(CreateProductReviewDTO createProductReviewDTO);

     ProductDTO toProductReviewDTO(ProductReviewEntity productReviewEntity);

     void toProductReviewEntity(UpdateProductReviewDTO updateProductReviewDTO,@MappingTarget ProductReviewEntity review);
}
