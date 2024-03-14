package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CategoryDTO;
import com.resul.ecommerce.dto.CreateCategoryDTO;
import com.resul.ecommerce.dto.UpdateCategoryDTO;
import com.resul.ecommerce.manager.CategoryManager;
import com.resul.ecommerce.mapper.CategoryMapper;
import com.resul.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryManager categoryManager;

    public List<CategoryDTO> findAll() {
        return categoryMapper.toCategoryDTOList(categoryManager.findAll());
    }

    public CategoryDTO findById(Long id) {
        var category = categoryManager.getCategory(id);
        return categoryMapper.toCategoryDTO(category);
    }

    public void save(CreateCategoryDTO createCategoryDTO) {
        var category = categoryMapper.toCategoryEntity(createCategoryDTO);
        categoryRepository.save(category);
    }

    public void update(Long id, UpdateCategoryDTO updateCategoryDTO) {
        var category = categoryManager.getCategory(id);
        categoryMapper.toCategoryEntity(updateCategoryDTO, category);
        categoryRepository.save(category);
    }

    public void delete(Long id) {
        var category = categoryManager.getCategory(id);
        category.setDeleted(true);
        categoryRepository.save(category);
    }
}
