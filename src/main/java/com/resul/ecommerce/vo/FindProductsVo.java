package com.resul.ecommerce.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FindProductsVo {
    private String namePhrase;
    private String descriptionPhrase;
    private BigDecimal price;
    private Long quantity;
}
