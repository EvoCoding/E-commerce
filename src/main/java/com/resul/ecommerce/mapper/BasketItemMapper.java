package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.AddToBasketDTO;
import com.resul.ecommerce.dto.BasketItemDTO;
import com.resul.ecommerce.repository.entity.BasketItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {
    BasketItemEntity toBasketItemEntity(AddToBasketDTO addToBasketDTO);
}
