package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.UserTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
    private UserTypeEnum userType;
}
