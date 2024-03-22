package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.*;
import com.resul.ecommerce.service.ProductService;
import com.resul.ecommerce.service.StoreService;
import com.resul.ecommerce.shared.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PageResponse<StoreDTO>> findAll(FindStoresDTO findStoresDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.findAll(findStoresDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateStoreDTO createStoreDTO){
        storeService.create(createStoreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateStoreDTO updateStoreDTO){
        storeService.update(id, updateStoreDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        storeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{storeId}/assign-seller")
    public ResponseEntity<Void> findById(@PathVariable Long storeId, Long sellerId) {
        storeService.assignSeller(storeId, sellerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
