package com.resul.ecommerce.dto;

import com.resul.ecommerce.repository.entity.OrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreatePaymentRequestDTO {
    private BigDecimal amount;
    private String currency;
    private String name;
    private String successUrl;
    private String cancelUrl;
    private Long orderId;
}
