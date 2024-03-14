package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubcategoryDTO {
    private String name;
    private Long categoryId;
}
