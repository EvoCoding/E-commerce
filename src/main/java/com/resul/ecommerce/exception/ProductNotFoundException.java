package com.resul.ecommerce.exception;

public class ProductNotFoundException extends NotFoundException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
