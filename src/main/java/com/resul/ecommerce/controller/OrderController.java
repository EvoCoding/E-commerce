package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateOrderDTO;
import com.resul.ecommerce.dto.OrderDTO;
import com.resul.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAllByCustomerId(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllByCustomerId(id));
    }
   @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateOrderDTO createOrderDTO){
        orderService.create(createOrderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
   }


}
