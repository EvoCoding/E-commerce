package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateOrderItemDTO {
    private int quantity;
    private int price;
    private Long productId;
    private Long orderId;
}
