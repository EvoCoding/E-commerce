package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateSellerDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.SellerDTO;
import com.resul.ecommerce.dto.UpdateSellerDTO;
import com.resul.ecommerce.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sellers")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateSellerDTO createSellerDTO) {
        sellerService.create(createSellerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateSellerDTO updateSellerDTO) {
        sellerService.update(id, updateSellerDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sellerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/{sellerId}/products")
    public ResponseEntity<List<ProductDTO>> getSellerProduct(@PathVariable Long sellerId){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSellerProduct(sellerId));
    }
}
