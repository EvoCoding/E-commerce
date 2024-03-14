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
                .orElseThrow(() -> new SellerNotFoundException("Customer not found with Id: " + id));
    }
    public List<SellerEntity> findAll(){
        return sellerRepository.findAll();
    }

}
