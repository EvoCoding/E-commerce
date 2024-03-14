package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateProductDTO;
import com.resul.ecommerce.dto.FindProductsDTO;
import com.resul.ecommerce.dto.ProductDTO;
import com.resul.ecommerce.dto.UpdateProductDTO;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.mapper.ProductMapper;
import com.resul.ecommerce.repository.ProductRepository;
import com.resul.ecommerce.shared.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductManager productManager;
    private final ProductRepository productRepository;

    public PageResponse<ProductDTO> findAll(FindProductsDTO findProductsDTO) {
        var productEntities = productManager.findAll(findProductsDTO);
        var content = productMapper.toProductDTOList(productEntities);
        return new PageResponse<>(content, productEntities.getTotalPages(), productEntities.getTotalElements());
    }
    public ProductDTO findById(@PathVariable Long id){
        var product = productManager.findByIdAndIsDeleted(id);
        return productMapper.toProductDTO(product);
    }
    public void create(CreateProductDTO createProductDTO){
        productRepository.save(productMapper.toProductEntity(createProductDTO));
    }
    public void update(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO){
        var product=productManager.getProduct(id);
        productMapper.toProductEntity(updateProductDTO,product);
        productRepository.save(product);
    }
    public void delete(@PathVariable Long id){
        var product=productManager.getProduct(id);
      product.setDeleted(true);
      productRepository.save(product);
    }



}
