package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.AddToBasketDTO;
import com.resul.ecommerce.manager.BasketItemManager;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.mapper.BasketItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketItemService {
    private final CustomerManager customerManager;
    private final JwtService jwtService;
    private final ProductManager productManager;
    private final BasketItemMapper basketItemMapper;
    private final BasketItemManager basketItemManager;

    public void addToBasket(AddToBasketDTO addToBasketDTO) {
        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
        var product = productManager.getProduct(addToBasketDTO.getProductId());
        var quantity = addToBasketDTO.getQuantity();
        if(product.getId() == addToBasketDTO.getProductId()){
        quantity = quantity +1;
        }
        var basketItem =  basketItemMapper.toBasketItemEntity(addToBasketDTO);
        basketItem.setProduct(product);


    }
}
