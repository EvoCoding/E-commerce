package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Double totalAmount;
    private Instant orderDate;
    private OrderStatusEnum orderStatus;
}
