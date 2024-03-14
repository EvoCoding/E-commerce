package com.resul.ecommerce.manager;

import com.resul.ecommerce.annotation.Manager;
import com.resul.ecommerce.dto.FindProductsDTO;
import com.resul.ecommerce.repository.entity.ProductEntity;
import com.resul.ecommerce.exception.ProductNotFoundException;
import com.resul.ecommerce.mapper.ProductMapper;
import com.resul.ecommerce.repository.ProductRepository;
import com.resul.ecommerce.specification.ProductSearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@RequiredArgsConstructor
@Manager
public class ProductManager {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: " + id));
    }
    public Page<ProductEntity> findAll(FindProductsDTO findProductsDTO) {
        var pageable = PageRequest.of(findProductsDTO.getPage(), findProductsDTO.getSize(), Sort.by("id").ascending());
        var findProductsVo = productMapper.toFindProductsVo(findProductsDTO);
        var productSearchSpecification = new ProductSearchSpecification(findProductsVo);
        return productRepository.findAll(productSearchSpecification, pageable);
    }
    public ProductEntity findByIdAndIsDeleted(Long id) {
        return productRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: " + id));
    }

}
