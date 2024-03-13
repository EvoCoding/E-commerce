package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
}
