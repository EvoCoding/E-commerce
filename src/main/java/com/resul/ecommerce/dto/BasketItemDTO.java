package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BasketItemDTO {
    private Long id;
    private Long productId;
    private int quantity;
    private String productName;
    private Double price;
}
