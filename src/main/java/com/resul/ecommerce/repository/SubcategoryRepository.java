package com.resul.ecommerce.repository;

import com.resul.ecommerce.repository.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Long> {
    Optional<SubcategoryEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
    @Query("select s from SubcategoryEntity s where s.isDeleted=false")
    List<SubcategoryEntity> findAllAndIsDeleted(boolean isDeleted);
}
