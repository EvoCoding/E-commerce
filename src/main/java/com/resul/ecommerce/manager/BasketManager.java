package com.resul.ecommerce.manager;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.repository.BasketRepository;
import com.resul.ecommerce.repository.entity.BasketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketManager {
    private final BasketRepository basketRepository;
    private final JwtService jwtService;
    private final CustomerManager customerManager;
    public BasketEntity getOrCreateBasketForCustomer() {
        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
        BasketEntity basket = customer.getBasket();
        if (basket == null) {
            basket = new BasketEntity();
            basket.setCustomer(customer);
            basket = basketRepository.save(basket);
        }
        return basket;
    }
}
