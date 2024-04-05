package com.resul.ecommerce.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Builder
public class CreatePaymentResponse {
    private String sessionId;
    private String sessionUrl;
}
