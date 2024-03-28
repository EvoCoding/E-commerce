package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    @Query(value = "SELECT orderItem FROM OrderItemEntity orderItem " +
            "JOIN orderItem.product p " +
            "JOIN p.seller s " +
            "JOIN s.store st " +
            "JOIN st.id " +
            "where st.id = :storeId ")
    List<OrderItemEntity> findAllByStoreId(Long storeId);
}
