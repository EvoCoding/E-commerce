package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.CreateDeliveryAddressDTO;
import com.resul.ecommerce.dto.DeliveryAddressDTO;
import com.resul.ecommerce.dto.UpdateDeliveryAddressDTO;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.manager.DeliveryAddressManager;
import com.resul.ecommerce.mapper.DeliveryAddressMapper;
import com.resul.ecommerce.repository.DeliveryAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final DeliveryAddressManager deliveryAddressManager;
    private final DeliveryAddressMapper deliveryAddressMapper;
    private final JwtService jwtService;
    private final CustomerManager customerManager;

    public List<DeliveryAddressDTO> findAll() {
        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
        var deliveryAddresses = deliveryAddressManager.findAll(customer.getId());
        return deliveryAddressMapper.toDeliveryAddressDTOList(deliveryAddresses);
    }

    public void create(CreateDeliveryAddressDTO createDeliveryAddressDTO) {
        var customer = customerManager.findByUsername(jwtService.getUserFromToken().getUsername());
        var deliveryAddress = deliveryAddressMapper.toDeliveryAddressEntity(createDeliveryAddressDTO);
        deliveryAddress.setCustomer(customer);
        deliveryAddressRepository.save(deliveryAddress);
    }

    public void update(Long id, UpdateDeliveryAddressDTO updateDeliveryAddressDTO) {
        var deliveryAddress = deliveryAddressManager.getDeliveryAddress(id);
        deliveryAddressMapper.toDeliveryAddressEntity(updateDeliveryAddressDTO, deliveryAddress);
        deliveryAddressRepository.save(deliveryAddress);
    }

    public void delete(Long id) {
        var deliveryAddress = deliveryAddressManager.getDeliveryAddress(id);
        deliveryAddress.setDeleted(true);
        deliveryAddressRepository.save(deliveryAddress);
    }
}
