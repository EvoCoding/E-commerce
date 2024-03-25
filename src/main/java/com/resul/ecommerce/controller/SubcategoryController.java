package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreateSubcategoryDTO;
import com.resul.ecommerce.dto.SubcategoryDTO;
import com.resul.ecommerce.dto.UpdateSubcategoryDTO;
import com.resul.ecommerce.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {
    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<SubcategoryDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(subcategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(subcategoryService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> create(CreateSubcategoryDTO createSubcategoryDTO){
        subcategoryService.create(createSubcategoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateSubcategoryDTO updateSubcategoryDTO){
        subcategoryService.update(id, updateSubcategoryDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        subcategoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
