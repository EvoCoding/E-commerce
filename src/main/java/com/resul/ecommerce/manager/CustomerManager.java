package com.resul.ecommerce.manager;

import com.resul.ecommerce.exception.CustomerNotFoundException;
import com.resul.ecommerce.exception.SellerNotFoundException;
import com.resul.ecommerce.repository.CustomerRepository;
import com.resul.ecommerce.repository.entity.CustomerEntity;
import com.resul.ecommerce.repository.entity.SellerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerManager {
    private final CustomerRepository customerRepository;

    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id: " + id));
    }

    public CustomerEntity findByUsername(String username) {
        return customerRepository.findByUsername(username)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + username));
    }

    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }
}
