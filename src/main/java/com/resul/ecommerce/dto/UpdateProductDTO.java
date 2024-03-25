package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductDTO {
    private Long subcategoryId;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
}
