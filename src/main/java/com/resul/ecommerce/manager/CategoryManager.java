package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.CategoryNotFoundException;
import com.resul.ecommerce.repository.CategoryRepository;
import com.resul.ecommerce.repository.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryManager {
    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with Id: " + id));
    }
}
