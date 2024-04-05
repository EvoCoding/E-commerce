package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.BasketItemDTO;
import com.resul.ecommerce.manager.BasketItemManager;
import com.resul.ecommerce.mapper.BasketItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasketService {
    private final BasketItemManager basketItemManager;
    private final BasketItemMapper basketItemMapper;

    public List<BasketItemDTO> getBasketDetails() {
        return basketItemManager.getBasketItems().stream()
                .map(basketItemEntity -> {
                    BasketItemDTO basketItemDTO = new BasketItemDTO();
                    basketItemDTO.setId(basketItemEntity.getId());
                    basketItemDTO.setPrice(basketItemEntity.getProduct().getPrice());
                    basketItemDTO.setProductId(basketItemEntity.getProduct().getId());
                    basketItemDTO.setProductName(basketItemEntity.getProduct().getName());
                    basketItemDTO.setQuantity(basketItemEntity.getQuantity());
                    return basketItemDTO;
                }).collect(Collectors.toList());
    }
}
