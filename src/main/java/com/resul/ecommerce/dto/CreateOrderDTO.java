package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.OrderItemEntity;
import com.resul.ecommerce.repository.entity.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class CreateOrderDTO {
    private Double totalAmount;
    private Instant orderDate;
    private OrderStatusEnum orderStatus;
    private List<OrderItemEntity> orderItems;
    private int deliveryAddressId;
}
