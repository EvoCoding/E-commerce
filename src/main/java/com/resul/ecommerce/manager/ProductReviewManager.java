package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.ProductNotFoundException;
import com.resul.ecommerce.mapper.ProductReviewMapper;
import com.resul.ecommerce.repository.ProductReviewRepository;
import com.resul.ecommerce.repository.entity.ProductReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductReviewManager {
    private final ProductReviewRepository productReviewRepository;

    public List<ProductReviewEntity> findAllByProductId(Long id){
        var productReviews = productReviewRepository.findAllByProductId(id);
        return productReviews;
    }

    public ProductReviewEntity findById(Long id) {
        return productReviewRepository.findById(id)
                .orElseThrow(() ->new ProductNotFoundException("ProductReview not found with id:" + id));
    }
}
