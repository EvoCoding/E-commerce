package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreRepository extends JpaRepository<StoreEntity, Long>, JpaSpecificationExecutor<StoreEntity> {
}
