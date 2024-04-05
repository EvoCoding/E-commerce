package com.resul.ecommerce.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Builder
public class StripeResponse<T> {
    private String status;
    private String message;
    private Integer httpStatus;
    private T data;
}
