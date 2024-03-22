package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {
    Optional<SellerEntity> findByUsername(String username);
}
