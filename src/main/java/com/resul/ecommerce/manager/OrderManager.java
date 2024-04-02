package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.OrderNotFoundException;
import com.resul.ecommerce.repository.OrderRepository;
import com.resul.ecommerce.repository.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderManager {
    private final OrderRepository orderRepository;
    public List<OrderEntity> findAllByCustomerId(Long id) {
        var orders = orderRepository.findALLByCustomerId(id);
        return orders;
    }

    public OrderEntity getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }
}
