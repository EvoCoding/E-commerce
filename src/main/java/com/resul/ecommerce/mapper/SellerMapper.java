package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateSellerDTO;
import com.resul.ecommerce.dto.AdminDTO;
import com.resul.ecommerce.dto.SellerDTO;
import com.resul.ecommerce.dto.UpdateSellerDTO;
import com.resul.ecommerce.repository.entity.SellerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    List<SellerDTO> toSellerDTOList(List<SellerEntity> sellerEntities);
    SellerDTO toSellerDTO(SellerEntity sellerEntity);
    SellerEntity toSellerEntity(CreateSellerDTO sellerDTO);
    void toSellerEntity(UpdateSellerDTO updateSellerDTO, @MappingTarget SellerEntity sellerEntity);
}
