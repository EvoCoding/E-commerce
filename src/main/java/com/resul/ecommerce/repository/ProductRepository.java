package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.ProductEntity;
import com.resul.ecommerce.spesification.ProductSearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Page<ProductEntity> findAll(ProductSearchSpecification productSearchSpecification, PageRequest pageable);
    Optional<ProductEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
