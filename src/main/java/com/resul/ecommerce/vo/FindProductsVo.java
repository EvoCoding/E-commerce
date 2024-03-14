package com.resul.ecommerce.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FindProductsVo {
    private Long subcategoryId;
    private String namePhrase;
    private String descriptionPhrase;
    private Double price;
    private Long quantity;
}
