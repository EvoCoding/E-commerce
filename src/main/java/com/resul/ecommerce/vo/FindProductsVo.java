package com.resul.ecommerce.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProductsVo {
    private Long subcategoryId;
    private Long storeId;
    private String namePhrase;
    private String descriptionPhrase;
    private Double price;
    private Integer stock;
    private Long quantity;
}
