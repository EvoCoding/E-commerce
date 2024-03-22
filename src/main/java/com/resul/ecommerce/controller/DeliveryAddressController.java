package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateDeliveryAddressDTO;
import com.resul.ecommerce.dto.DeliveryAddressDTO;
import com.resul.ecommerce.dto.UpdateDeliveryAddressDTO;
import com.resul.ecommerce.service.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @GetMapping
    public ResponseEntity<List<DeliveryAddressDTO>> findById(){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryAddressService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateDeliveryAddressDTO createDeliveryAddressDTO){
        deliveryAddressService.create(createDeliveryAddressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateDeliveryAddressDTO updateDeliveryAddressDTO){
        deliveryAddressService.update(id, updateDeliveryAddressDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        deliveryAddressService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
