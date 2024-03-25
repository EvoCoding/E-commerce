package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDeliveryAddressDTO {
    private String city;
    private String region;
    private String street;
    private String postalCode;
}
