package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateProductDTO;
import com.resul.ecommerce.dto.FindProductsDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.UpdateProductDTO;
import com.resul.ecommerce.service.ProductService;
import com.resul.ecommerce.shared.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PageResponse<ProductDTO>> findAll(FindProductsDTO findProductsDTO){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(findProductsDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductDTO createProductDTO){
        productService.create(createProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
   @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO){
        productService.update(id,updateProductDTO);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
