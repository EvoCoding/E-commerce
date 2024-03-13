package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class ProductDTO {
private Long id;
private String name;
private String description;
private BigDecimal price;
private int quantity;
private Instant createdAt;
private Instant modifiedAt;
}
