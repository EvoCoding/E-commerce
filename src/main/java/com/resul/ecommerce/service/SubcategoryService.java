package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateSubcategoryDTO;
import com.resul.ecommerce.dto.SubcategoryDTO;
import com.resul.ecommerce.dto.UpdateSubcategoryDTO;
import com.resul.ecommerce.manager.CategoryManager;
import com.resul.ecommerce.manager.SubcategoryManager;
import com.resul.ecommerce.mapper.SubcategoryMapper;
import com.resul.ecommerce.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    private final SubcategoryManager subcategoryManager;
    private final CategoryManager categoryManager;


    public List<SubcategoryDTO> findAll() {
        var subcategories = subcategoryManager.findAll();
        return subcategoryMapper.toSubategoryDTOList(subcategories);
    }

    public SubcategoryDTO findById(Long id) {
        var subcategory = subcategoryManager.getSubcategory(id);
        return subcategoryMapper.toSubcategoryDTO(subcategory);
    }

    public void create(CreateSubcategoryDTO createSubcategoryDTO) {
        var category = categoryManager.getCategory(createSubcategoryDTO.getCategoryId());
        var subcategory = subcategoryMapper.toSubcategoryEntity(createSubcategoryDTO);
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);
    }

    public void update(Long id, UpdateSubcategoryDTO updateSubcategoryDTO) {
        var subcategory = subcategoryManager.getSubcategory(id);
        subcategoryMapper.toSubcategoryEntity(updateSubcategoryDTO, subcategory);
        subcategoryRepository.save(subcategory);
    }

    public void delete(Long id) {
        var subcategory = subcategoryManager.getSubcategory(id);
        subcategory.setDeleted(true);
        subcategoryRepository.save(subcategory);
    }
}
