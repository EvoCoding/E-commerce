package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.BasketItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItemEntity, Long> {
    @Query("SELECT b FROM BasketItemEntity b WHERE b.basket.id=:basketId AND b.product.id=:productId")
    Optional<BasketItemEntity> findByBasketIdAndProductId(Long basketId, Long productId);

    @Query("SELECT b FROM BasketItemEntity b WHERE b.basket.id=:basketId")
    List<BasketItemEntity> findAllByBasketId(Long basketId);
}
