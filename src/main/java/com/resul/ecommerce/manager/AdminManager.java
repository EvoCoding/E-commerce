package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.AdminNotFoundException;
import com.resul.ecommerce.repository.AdminRepository;
import com.resul.ecommerce.repository.entity.AdminEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminManager {
    private final AdminRepository adminRepository;

    public AdminEntity findById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with Id: " + id));
    }
    public List<AdminEntity> findAll(){
        return adminRepository.findAll();
    }
}
