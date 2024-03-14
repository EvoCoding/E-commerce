package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.CategoryNotFoundException;
import com.resul.ecommerce.repository.SubcategoryRepository;
import com.resul.ecommerce.repository.entity.SubcategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubcategoryManager {
    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryEntity getSubcategory(Long id){
        return subcategoryRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new CategoryNotFoundException("Subcategory not found with Id: " + id));
    }

    public List<SubcategoryEntity> findAll(){
        return subcategoryRepository.findAllAndIsDeleted(false);
    }
}
