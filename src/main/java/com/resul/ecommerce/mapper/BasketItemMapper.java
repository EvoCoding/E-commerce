package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.AddToBasketDTO;
import com.resul.ecommerce.dto.BasketItemDTO;
import com.resul.ecommerce.repository.entity.BasketItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {
    BasketItemEntity toBasketItemEntity(AddToBasketDTO addToBasketDTO);
    List<BasketItemDTO> toBasketItemDTOList(List<BasketItemEntity> basketItemEntities);
}
