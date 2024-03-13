package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateCustomerDTO;
import com.resul.ecommerce.dto.CustomerDTO;
import com.resul.ecommerce.dto.UpdateCustomerDTO;
import com.resul.ecommerce.manager.CustomerManager;
import com.resul.ecommerce.mapper.CustomerMapper;
import com.resul.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerManager customerManager;
    private final PasswordEncoder passwordEncoder;

    public List<CustomerDTO> findAll() {
        return customerMapper.toCustomerDTOList(customerManager.findAll());
    }

    public CustomerDTO findById(Long id) {
        var customer = customerManager.findById(id);
        return customerMapper.toCustomerDTO(customer);
    }

    public void create(CreateCustomerDTO customerDTO) {
        var customer = customerMapper.toCustomerEntity(customerDTO);
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customerRepository.save(customer);
    }

    public void update(Long id, UpdateCustomerDTO updateCustomerDTO) {
        var customer = customerManager.findById(id);
        customerMapper.toCustomerEntity(updateCustomerDTO, customer);
        customer.setPassword(passwordEncoder.encode(updateCustomerDTO.getPassword()));
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        var customer = customerManager.findById(id);
        customer.setDeleted(true);
        customerRepository.save(customer);
    }
}
