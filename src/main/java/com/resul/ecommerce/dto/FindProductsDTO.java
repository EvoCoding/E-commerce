package com.resul.ecommerce.dto;

import com.resul.ecommerce.shared.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProductsDTO extends PageRequest {
    private Long subcategoryId;
    private Long storeId;
    private String namePhrase;
    private String descriptionPhrase;
    private Double price;
    private Integer stock;
    private Integer quantity;
}
