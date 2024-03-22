package com.resul.ecommerce.mapper;

import com.resul.ecommerce.dto.CreateDeliveryAddressDTO;
import com.resul.ecommerce.dto.DeliveryAddressDTO;
import com.resul.ecommerce.dto.UpdateDeliveryAddressDTO;
import com.resul.ecommerce.repository.entity.DeliveryAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryAddressMapper {
    DeliveryAddressEntity toDeliveryAddressEntity(CreateDeliveryAddressDTO createDeliveryAddressDTO);
    List<DeliveryAddressDTO> toDeliveryAddressDTOList(List<DeliveryAddressEntity> deliveryAddressEntities);

    void toDeliveryAddressEntity(UpdateDeliveryAddressDTO updateDeliveryAddressDTO, @MappingTarget DeliveryAddressEntity deliveryAddress);

    DeliveryAddressDTO toDeliveryAddressDTO(DeliveryAddressEntity deliveryAddress);
}
