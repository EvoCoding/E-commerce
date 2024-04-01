package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToBasketDTO {
    private Long productId;
    private int quantity;
}
