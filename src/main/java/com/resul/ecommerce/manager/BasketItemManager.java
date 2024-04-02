package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.BasketItemNotFoundException;
import com.resul.ecommerce.repository.BasketItemRepository;
import com.resul.ecommerce.repository.entity.BasketItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketItemManager {
    private final BasketItemRepository basketItemRepository;
    public BasketItemEntity getBasketItemByBasketId(Long basketId) {
        return basketItemRepository.findByBasketId(basketId)
                .orElse(null);
    }
}
