package com.resul.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class ErrorDTO {
    private String message;
    private LocalDateTime timestamp;
}
