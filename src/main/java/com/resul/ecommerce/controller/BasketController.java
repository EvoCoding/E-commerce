package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.BasketItemDTO;
import com.resul.ecommerce.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baskets")
@AllArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @GetMapping
    public ResponseEntity<List<BasketItemDTO>> getBasketDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.getBasketDetails());
    }
    

}
