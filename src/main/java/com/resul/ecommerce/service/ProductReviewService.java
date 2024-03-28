package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.CreateProductReviewDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.ProductReviewDTO;
import com.resul.ecommerce.dto.UpdateProductReviewDTO;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.manager.ProductReviewManager;
import com.resul.ecommerce.mapper.ProductReviewMapper;
import com.resul.ecommerce.repository.ProductReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReviewService {
    private final ProductReviewMapper productReviewMapper;
    private final ProductReviewManager productReviewManager;
    private final JwtService jwtService;
    private final CustomerManager customerManager;
    private final ProductManager productManager;
    private final ProductReviewRepository productReviewRepository;


    public List<ProductReviewDTO> findAllByProductId(Long id) {
        return productReviewMapper.toProductReviewsDTOList(productReviewManager.findAllByProductId(id));
    }

    public void create(CreateProductReviewDTO createProductReviewDTO) {
        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
        var product = productManager.getProduct(createProductReviewDTO.getProductId());
        var review = productReviewMapper.toProductReviewEntity(createProductReviewDTO);
        review.setCustomer(customer);
        review.setProduct(product);
        productReviewRepository.save(review);
    }

    public void update(Long id, UpdateProductReviewDTO updateProductReviewDTO) {
        var review =productReviewManager.findById(id);
        productReviewMapper.toProductReviewEntity(updateProductReviewDTO,review);
        productReviewRepository.save(review);

    }

    public ProductDTO findById(Long id) {
        return productReviewMapper.toProductReviewDTO(productReviewManager.findById(id));
    }
}
