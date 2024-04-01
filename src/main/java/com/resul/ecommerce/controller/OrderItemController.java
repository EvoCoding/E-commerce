package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateOrderItemDTO;
import com.resul.ecommerce.dto.OrderItemDTO;
import com.resul.ecommerce.repository.entity.OrderItemEntity;
import com.resul.ecommerce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAllByStoreId(@RequestParam Long storeId){
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.findAllByStoreId(storeId));
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateOrderItemDTO createOrderItemDTO){
        orderItemService.create(createOrderItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
