package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.ProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReviewEntity,Long> {

    List<ProductReviewEntity> findAllByProductId(Long id);
}
