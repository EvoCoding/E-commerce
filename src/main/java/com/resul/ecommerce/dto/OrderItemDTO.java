package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private int price;
}
