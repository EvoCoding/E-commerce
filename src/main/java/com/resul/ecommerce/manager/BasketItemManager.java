package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.BasketItemNotFoundException;
import com.resul.ecommerce.repository.BasketItemRepository;
import com.resul.ecommerce.repository.entity.BasketItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BasketItemManager {
    private final BasketItemRepository basketItemRepository;
    private final CustomerManager customerManager;
    public List<BasketItemEntity> getBasketItems(){
        var customer = customerManager.getCustomerFromToken();
        return basketItemRepository.findAllByBasketId(customer.getBasket().getId());
    }

    public BasketItemEntity getBasketItemByBasketIdAndProductId(Long basketId, Long productId) {
        return basketItemRepository.findByBasketIdAndProductId(basketId, productId)
                .orElse(null);
    }
}
