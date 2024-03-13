package com.resul.ecommerce.service;

import com.resul.ecommerce.auth.JwtService;
import com.resul.ecommerce.dto.AuthenticationRequestDTO;
import com.resul.ecommerce.dto.AuthenticationResponseDTO;
import com.resul.ecommerce.dto.RegisterRequestDTO;
import com.resul.ecommerce.repository.entity.AdminEntity;
import com.resul.ecommerce.repository.entity.CustomerEntity;
import com.resul.ecommerce.repository.entity.SellerEntity;
import com.resul.ecommerce.repository.entity.UserEntity;
import com.resul.ecommerce.repository.AdminRepository;
import com.resul.ecommerce.repository.CustomerRepository;
import com.resul.ecommerce.repository.SellerRepository;
import com.resul.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;

    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        var userOptional = userRepository.findByUsername(request.getUsername());

        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        var user = createUserByUserType(request);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    private UserEntity createUserByUserType(RegisterRequestDTO registrationDto) {
        switch (registrationDto.getUserType()) {
            case ADMIN -> {
                AdminEntity admin = new AdminEntity();
                admin.setUsername(registrationDto.getUsername());
                admin.setEmail(registrationDto.getEmail());
                admin.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
                return adminRepository.save(admin);
            }
            case SELLER -> {
                SellerEntity seller = new SellerEntity();
                seller.setUsername(registrationDto.getUsername());
                seller.setEmail(registrationDto.getEmail());
                seller.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
                return sellerRepository.save(seller);
            }
            case CUSTOMER -> {
                CustomerEntity customer = new CustomerEntity();
                customer.setUsername(registrationDto.getUsername());
                customer.setEmail(registrationDto.getEmail());
                customer.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
                return customerRepository.save(customer);
            }
            default -> throw new IllegalArgumentException("Unsupported user type");
        }
    }
}
