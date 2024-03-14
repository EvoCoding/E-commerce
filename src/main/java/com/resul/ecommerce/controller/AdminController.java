package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.AdminDTO;
import com.resul.ecommerce.dto.CreateAdminDTO;
import com.resul.ecommerce.dto.UpdateAdminDTO;
import com.resul.ecommerce.repository.entity.AdminEntity;
import com.resul.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping
    public ResponseEntity<List<AdminDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdminEntity> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findById(id));
    }
    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@RequestBody CreateAdminDTO createAdminDTO){
        adminService.create(createAdminDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateAdminDTO updateAdminDTO){
        adminService.update(id,updateAdminDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        adminService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
