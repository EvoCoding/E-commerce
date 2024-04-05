package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.AddToBasketDTO;
import com.resul.ecommerce.manager.BasketItemManager;
import com.resul.ecommerce.manager.BasketManager;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.repository.BasketItemRepository;
import com.resul.ecommerce.repository.entity.BasketItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketItemService {
    private final ProductManager productManager;
    private final BasketItemManager basketItemManager;
    private final BasketManager basketManager;
    private BasketItemRepository basketItemRepository;

    public void addToBasket(AddToBasketDTO addToBasketDTO) {
        var product = productManager.getProduct(addToBasketDTO.getProductId());
        var basket = basketManager.getOrCreateBasketForCustomer();
        var basketItem = basketItemManager.getBasketItemByBasketIdAndProductId(basket.getId(), product.getId());

        if (basketItem != null) {
            basketItem.setQuantity(basketItem.getQuantity() + addToBasketDTO.getQuantity());
        } else {
            basketItem = new BasketItemEntity();
            basketItem.setBasket(basket);
            basketItem.setProduct(product);
            basketItem.setQuantity(addToBasketDTO.getQuantity());
        }
        basketItemRepository.save(basketItem);
    }
}