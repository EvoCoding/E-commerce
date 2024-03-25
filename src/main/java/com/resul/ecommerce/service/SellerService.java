package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateSellerDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.SellerDTO;
import com.resul.ecommerce.dto.UpdateSellerDTO;
import com.resul.ecommerce.manager.SellerManager;
import com.resul.ecommerce.mapper.ProductMapper;
import com.resul.ecommerce.mapper.SellerMapper;
import com.resul.ecommerce.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerMapper sellerMapper;
    private final SellerManager sellerManager;
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProductMapper productMapper;

    public List<SellerDTO> findAll() {
        return sellerMapper.toSellerDTOList(sellerManager.findAll());
    }

    public SellerDTO findById(Long id) {
        var seller = sellerManager.findById(id);
        return sellerMapper.toSellerDTO(seller);
    }

    public void create(CreateSellerDTO sellerDTO) {
        var seller = sellerMapper.toSellerEntity(sellerDTO);
        seller.setPassword(passwordEncoder.encode(sellerDTO.getPassword()));
        sellerRepository.save(seller);
    }

    public void update(Long id, UpdateSellerDTO updateSellerDTO) {
        var seller = sellerManager.findById(id);
        sellerMapper.toSellerEntity(updateSellerDTO, seller);
        seller.setPassword(passwordEncoder.encode(updateSellerDTO.getPassword()));
        sellerRepository.save(seller);
    }

    public void delete(Long id) {
        var seller = sellerManager.findById(id);
        seller.setDeleted(true);
        sellerRepository.save(seller);

    }

    public List<ProductDTO> getSellerProduct(Long sellerId) {
        var seller = sellerManager.findById(sellerId);
        var products = seller.getProducts();
        return productMapper.toProductDTOList(products);
    }
}
