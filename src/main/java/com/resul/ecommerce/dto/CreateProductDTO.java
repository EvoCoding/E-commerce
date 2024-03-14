package com.resul.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductDTO {

    @NotBlank(message = "Cannot be empty")
    private Long subcategoryId;

    @NotBlank(message = "Cannot be empty")
    private String name;

    @NotBlank(message = "Cannot be empty")
    private String description;

    @NotBlank(message = "Cannot be empty")
    private BigDecimal price;

    @NotBlank(message = "Cannot be empty")
    private int quantity;

}
