package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.AddToBasketDTO;
import com.resul.ecommerce.dto.BasketItemDTO;
import com.resul.ecommerce.service.BasketItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket-items")
@AllArgsConstructor
public class BasketItemController {
    private final BasketItemService basketItemService;
  @PostMapping
  public ResponseEntity<Void> addToBasket(@RequestBody AddToBasketDTO addToBasketDTO){
      basketItemService.addToBasket(addToBasketDTO);
   return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
