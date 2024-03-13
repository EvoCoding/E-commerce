package com.resul.ecommerce.dto;

import com.resul.ecommerce.shared.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FindProductsDTO extends PageRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
}
