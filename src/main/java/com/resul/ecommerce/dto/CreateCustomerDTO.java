package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDTO {
    private String username;
    private String email;
    private String phone;
    private String password;
}
