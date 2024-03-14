package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateProductDTO;
import com.resul.ecommerce.dto.FindProductsDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.UpdateProductDTO;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.manager.SubcategoryManager;
import com.resul.ecommerce.mapper.ProductMapper;
import com.resul.ecommerce.repository.ProductRepository;
import com.resul.ecommerce.shared.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductManager productManager;
    private final ProductRepository productRepository;
    private final SubcategoryManager subcategoryManager;

    public PageResponse<ProductDTO> findAll(FindProductsDTO findProductsDTO) {
        var productEntities = productManager.findAll(findProductsDTO);
        var content = productMapper.toProductDTOList(productEntities);
        return new PageResponse<>(content, productEntities.getTotalPages(), productEntities.getTotalElements());
    }

    public ProductDTO findById(Long id) {
        var product = productManager.getProduct(id);
        return productMapper.toProductDTO(product);
    }

    public void create(CreateProductDTO createProductDTO) {
        var subcategory = subcategoryManager.getSubcategory(createProductDTO.getSubcategoryId());
        var product = productMapper.toProductEntity(createProductDTO);
        product.setSubcategory(subcategory);
        productRepository.save(product);
    }

    public void update(Long id, UpdateProductDTO updateProductDTO) {
        var subcategory = subcategoryManager.getSubcategory(updateProductDTO.getSubcategoryId());
        var product = productManager.getProduct(id);
        product.setSubcategory(subcategory);
        productMapper.toProductEntity(updateProductDTO, product);
        productRepository.save(product);
    }

    public void delete(Long id) {
        var product = productManager.getProduct(id);
        product.setDeleted(true);
        productRepository.save(product);
    }

}
