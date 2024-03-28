package com.resul.ecommerce.manager;

import com.resul.ecommerce.repository.OrderItemRepository;
import com.resul.ecommerce.repository.OrderRepository;
import com.resul.ecommerce.repository.entity.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderItemManager {
    private final OrderItemRepository orderItemRepository;
    public List<OrderItemEntity> findAllByStoreId(Long storeId) {
        var orderItem=orderItemRepository.findAllByStoreId(storeId);
        return orderItem;
    }
}
