package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {
    @Query("SELECT b FROM BasketEntity b WHERE b.customer.id=:customerId")
    Optional<BasketEntity> findByCustomerId(Long customerId);
}
