package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.AdminDTO;
import com.resul.ecommerce.dto.CreateAdminDTO;
import com.resul.ecommerce.dto.UpdateAdminDTO;
import com.resul.ecommerce.manager.AdminManager;
import com.resul.ecommerce.mapper.AdminMapper;
import com.resul.ecommerce.repository.AdminRepository;
import com.resul.ecommerce.repository.entity.AdminEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final AdminManager adminManager;
    private final PasswordEncoder passwordEncoder;

    public List<AdminDTO> findAll() {
        return adminMapper.toSellerDTOList(adminManager.findAll());
    }

    public AdminEntity findById(Long id) {
        var admin = adminManager.findById(id);
        return adminMapper.toAdminDTO(admin);
    }

    public void create(CreateAdminDTO adminDTO) {
        var admin = adminMapper.toAdminEntity(adminDTO);
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminRepository.save(admin);
    }

    public void update(Long id, UpdateAdminDTO updateAdminDTO) {
        var admin = adminManager.findById(id);
        adminMapper.toAdminEntity(updateAdminDTO, admin);
        admin.setPassword(passwordEncoder.encode(updateAdminDTO.getPassword()));
        adminRepository.save(admin);
    }

    public void delete(Long id) {
        var admin = adminManager.findById(id);
        admin.setDeleted(true);
        adminRepository.save(admin);
    }
}
