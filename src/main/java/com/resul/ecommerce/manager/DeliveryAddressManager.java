package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.DeliveryAddressNotFoundException;
import com.resul.ecommerce.repository.DeliveryAddressRepository;
import com.resul.ecommerce.repository.entity.DeliveryAddressEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeliveryAddressManager {
    private final DeliveryAddressRepository deliveryAddressRepository;

    public List<DeliveryAddressEntity> findAll(Long customerId) {
        return deliveryAddressRepository.findAllByCustomerId(customerId);
    }

    public DeliveryAddressEntity getDeliveryAddress(Long id) {
        return deliveryAddressRepository.findById(id)
                .orElseThrow(() -> new DeliveryAddressNotFoundException("Delivery address not found with id: " + id));
    }
}
