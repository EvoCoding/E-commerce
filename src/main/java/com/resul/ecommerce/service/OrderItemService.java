package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.CreateOrderItemDTO;
import com.resul.ecommerce.dto.OrderItemDTO;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.manager.OrderItemManager;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.mapper.OrderItemMapper;
import com.resul.ecommerce.repository.OrderItemRepository;
import com.resul.ecommerce.repository.entity.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
private final OrderItemMapper orderItemMapper;
private final OrderItemRepository orderItemRepository;
private final OrderItemManager orderItemManager;
private final ProductManager productManager;
private final JwtService jwtService;
    public List<OrderItemDTO> findAllByStoreId(Long storeId) {
        return orderItemMapper.toOrderItemDTOList(orderItemManager.findAllByStoreId(storeId));
    }

    public void create(CreateOrderItemDTO createOrderItemDTO) {
        var product = productManager.getProduct(createOrderItemDTO.getProductId());
        var orderItem = orderItemMapper.toOrderItemEntity(createOrderItemDTO);
        orderItem.setId(product.getId());
        orderItem.setOrder(orderItem.getOrder());
        orderItemRepository.save(orderItem);
    }
}
