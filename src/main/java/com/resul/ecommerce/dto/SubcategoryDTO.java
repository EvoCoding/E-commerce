package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubcategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
