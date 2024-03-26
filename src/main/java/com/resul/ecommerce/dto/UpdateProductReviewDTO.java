package com.resul.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UpdateProductReviewDTO {
    private int rating;
    private String reviewText;
    private Instant date;
    private Long productId;
}