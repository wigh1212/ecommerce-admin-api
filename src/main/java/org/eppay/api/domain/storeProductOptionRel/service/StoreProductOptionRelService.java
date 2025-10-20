package org.eppay.api.domain.storeProductOptionRel.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProduct.repository.StoreProductRepository;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;
import org.eppay.api.domain.storeProductOption.repository.StoreProductOptionRepository;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelEntity;
import org.eppay.api.domain.storeProductOptionRel.repository.StoreProductOptionRelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreProductOptionRelService {

    private final StoreProductOptionRelRepository repository;
    private final StoreProductOptionRepository storeProductOptionRepository;
    private final StoreProductRepository storeProductRepository;

    private final ObjectMapper objectMapper;

    @Transactional
    public String create(StoreProductOptionRelDto.CreateRequest request) throws Exception{

        StoreProductEntity storeProductEntity=storeProductRepository.findByIdAndStoreId(request.getStoreProductId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_PRODUCT));

        System.out.println(objectMapper.writeValueAsString(request));

        StoreProductOptionEntity storeProductOptionEntity = storeProductOptionRepository.findByIdAndStoreId(request.getStoreProductOptionId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_PRODUCT_OPTION));

        storeProductEntity.addOption( storeProductOptionEntity);

        storeProductRepository.save(storeProductEntity);

        return "200";
    }

    public String delete(StoreProductOptionRelDto.DeleteRequest request) throws Exception{
        System.out.println(objectMapper.writeValueAsString(request));
        repository.delete(repository.findByStoreProductIdAndStoreProductOptionId( request.getStoreProductId(),request.getStoreProductOptionId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE) ));
        return "200";
    }

//    public Boolean isExist(StoreProductOptionRelDto.SearchRequest request) throws Exception{
//        return repository.existsByStoreProductIdAndStoreProductOptionId(request.getStoreProductId(), request.getStoreProductOptionId());
//    }
}