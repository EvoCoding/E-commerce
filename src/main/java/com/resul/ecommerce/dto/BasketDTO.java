package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BasketDTO {
    private Long id;
    private List<BasketItemDTO> items;
}
