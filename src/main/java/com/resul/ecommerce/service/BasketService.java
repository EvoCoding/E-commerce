package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.repository.BasketRepository;
import com.resul.ecommerce.repository.entity.BasketEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketService {
//private final BasketRepository basketRepository;
//private final JwtService jwtService;
//private final CustomerManager customerManager;
//    public BasketEntity getOrCreateBasketForCustomer() {
//        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
//
////        if (customer == null) {
////            // Handle case where customer doesn't exist
////            return null;
////        }
//
//        BasketEntity basket = customer.getBasket();
//
//        if (basket == null) {
//            basket = new BasketEntity();
//            basket.setCustomer(customer);
//            basket = basketRepository.save(basket);
//        }
//
//        return basket;
//    }
}
