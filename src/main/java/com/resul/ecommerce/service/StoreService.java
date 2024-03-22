package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreateStoreDTO;
import com.resul.ecommerce.dto.FindStoresDTO;
import com.resul.ecommerce.dto.StoreDTO;
import com.resul.ecommerce.dto.UpdateStoreDTO;
import com.resul.ecommerce.manager.SellerManager;
import com.resul.ecommerce.manager.StoreManager;
import com.resul.ecommerce.mapper.StoreMapper;
import com.resul.ecommerce.repository.StoreRepository;
import com.resul.ecommerce.shared.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final StoreManager storeManager;
    private final StoreMapper storeMapper;
    private final SellerManager sellerManager;

    public PageResponse<StoreDTO> findAll(FindStoresDTO findStoresDTO) {
        var storeEntities = storeManager.findAll(findStoresDTO);
        var content = storeMapper.toStoreDTOList(storeEntities);
        return new PageResponse<>(content, storeEntities.getTotalPages(), storeEntities.getTotalElements());
    }

    public StoreDTO findById(Long id) {
        var store = storeManager.getStore(id);
        return storeMapper.toStoreDTO(store);
    }

    public void create(CreateStoreDTO createStoreDTO) {
        var store = storeMapper.toStoreEntity(createStoreDTO);
        storeRepository.save(store);
    }

    public void update(Long id, UpdateStoreDTO updateStoreDTO) {
        var store = storeManager.getStore(id);
        storeMapper.toStoreEntity(updateStoreDTO, store);
        storeRepository.save(store);
    }

    public void delete(Long id) {
        var store = storeManager.getStore(id);
        store.setDeleted(true);
        storeRepository.save(store);
    }

    public void assignSeller(Long storeId, Long sellerId) {
        var store = storeManager.getStore(storeId);
        var seller = sellerManager.findById(sellerId);
        seller.setStore(store);
    }
}
