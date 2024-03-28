package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateProductReviewDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.ProductReviewDTO;
import com.resul.ecommerce.dto.UpdateProductReviewDTO;
import com.resul.ecommerce.service.ProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @GetMapping
    public ResponseEntity<List<ProductReviewDTO>> findAllByProductId(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productReviewService.findAllByProductId(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductReviewDTO createProductReviewDTO) {
        productReviewService.create(createProductReviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productReviewService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateProductReviewDTO updateProductReviewDTO){
        productReviewService.update(id,updateProductReviewDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
