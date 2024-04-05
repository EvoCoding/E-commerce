package com.resul.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CapturePaymentResponse {
    private String sessionId;
    private String sessionStatus;
    private String paymentStatus;
}
