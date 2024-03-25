package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.SellerNotFoundException;
import com.resul.ecommerce.repository.SellerRepository;
import com.resul.ecommerce.repository.entity.SellerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SellerManager {
    private final SellerRepository sellerRepository;

    public SellerEntity findById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new SellerNotFoundException("Seller not found with Id: " + id));
    }

    public SellerEntity findByUsername(String username) {
        return sellerRepository.findByUsername(username)
                .orElseThrow(() -> new SellerNotFoundException("Seller not found: " + username));
    }

    public List<SellerEntity> findAll(){
        return sellerRepository.findAll();
    }

}
