package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.CreateOrderDTO;
import com.resul.ecommerce.dto.OrderDTO;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.manager.OrderManager;
import com.resul.ecommerce.manager.ProductManager;
import com.resul.ecommerce.mapper.OrderMapper;
import com.resul.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
private final OrderRepository orderRepository;
private final OrderMapper orderMapper;
private final OrderManager orderManager;
private final CustomerManager customerManager;

    public List<OrderDTO> findAllByCustomerId(Long id) {
        return orderMapper.toOrderDTOList(orderManager.findAllByCustomerId(id));
    }

    public void create(CreateOrderDTO createOrderDTO) {
        var customer = customerManager.getCustomerFromToken();
        var deliveryAddress = customer.getAddresses().get(createOrderDTO.getDeliveryAddressId());
        var order = orderMapper.toOrderEntity(createOrderDTO);
        order.setCustomer(customer);
        order.setDeliveryAddress(deliveryAddress);
        orderRepository.save(order);
    }
}
