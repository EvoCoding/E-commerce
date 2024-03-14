package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO {
    private String username;
    private String email;
    private String phone;
    private String password;
}
