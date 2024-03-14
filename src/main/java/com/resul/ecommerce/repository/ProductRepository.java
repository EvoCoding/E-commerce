package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.ProductEntity;
import com.resul.ecommerce.specification.ProductSearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>, JpaSpecificationExecutor<ProductEntity> {

    Optional<ProductEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
