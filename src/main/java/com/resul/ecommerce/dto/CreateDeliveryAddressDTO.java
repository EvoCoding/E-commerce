package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.CustomerEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDeliveryAddressDTO {
    private String city;
    private String region;
    private String street;
    private String postalCode;
}
