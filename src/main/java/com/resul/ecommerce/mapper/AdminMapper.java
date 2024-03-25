package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.AdminDTO;
import com.resul.ecommerce.dto.CreateAdminDTO;
import com.resul.ecommerce.dto.UpdateAdminDTO;
import com.resul.ecommerce.repository.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    List<AdminDTO> toSellerDTOList(List<AdminEntity> all);
    AdminEntity toAdminDTO(AdminEntity admin);

    AdminEntity toAdminEntity(CreateAdminDTO createAdminDTO);

    void toAdminEntity(UpdateAdminDTO updateAdminDTO,@MappingTarget AdminEntity adminEntity);
}
