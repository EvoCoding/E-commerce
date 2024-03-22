package com.resul.ecommerce.manager;

import com.resul.ecommerce.dto.FindStoresDTO;
import com.resul.ecommerce.exception.StoreNotFoundException;
import com.resul.ecommerce.mapper.StoreMapper;
import com.resul.ecommerce.repository.StoreRepository;
import com.resul.ecommerce.repository.entity.StoreEntity;
import com.resul.ecommerce.specification.StoreSearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreManager {
    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreEntity getStore(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException("Store not found with Id: " + id));
    }

    public Page<StoreEntity> findAll(FindStoresDTO findStoresDTO) {
        var pageable = PageRequest.of(findStoresDTO.getPage(), findStoresDTO.getSize(), Sort.by("id").ascending());
        var findStoresVo = storeMapper.toFindStoreVo(findStoresDTO);
        var specification = new StoreSearchSpecification(findStoresVo);
        return storeRepository.findAll(specification, pageable);
    }
}
