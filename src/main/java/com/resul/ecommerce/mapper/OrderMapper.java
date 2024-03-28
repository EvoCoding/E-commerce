package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateOrderDTO;
import com.resul.ecommerce.dto.OrderDTO;
import com.resul.ecommerce.repository.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    List<OrderDTO> toOrderDTOList(List<OrderEntity> orderEntities);

    OrderEntity toOrderEntity(CreateOrderDTO createOrderDTO);
}
