package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateOrderItemDTO;
import com.resul.ecommerce.dto.OrderItemDTO;
import com.resul.ecommerce.repository.entity.OrderItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    List<OrderItemDTO> toOrderItemDTOList(List<OrderItemEntity> orderItemEntities);

    OrderItemEntity toOrderItemEntity(CreateOrderItemDTO createOrderItemDTO);
}
