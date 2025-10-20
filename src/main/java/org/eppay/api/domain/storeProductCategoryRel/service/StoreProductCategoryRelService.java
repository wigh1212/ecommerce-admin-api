package org.eppay.api.domain.storeProductCategoryRel.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProduct.repository.StoreProductRepository;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryEntity;
import org.eppay.api.domain.storeProductCategory.repository.StoreProductCategoryRepository;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;
import org.eppay.api.domain.storeProductCategoryRel.repository.StoreProductCategoryRelRepository;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreProductCategoryRelService {

    private final StoreProductCategoryRelRepository repository;
    private final StoreProductCategoryRepository storeProductCategoryRepository;
    private final StoreProductRepository storeProductRepository;

    private final ObjectMapper objectMapper;

    @Transactional
    public String create(StoreProductCategoryRelDto.CreateRequest request) throws Exception{

        StoreProductCategoryEntity storeProductCategoryEntity=storeProductCategoryRepository.findByIdAndStoreId(request.getStoreProductCategoryId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_CATEGORY));

        StoreProductEntity storeProductEntity=storeProductRepository.findByIdAndStoreId(request.getStoreProductId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_PRODUCT ));

        storeProductCategoryEntity.addProduct(storeProductEntity) ;

        storeProductCategoryRepository.save(storeProductCategoryEntity);
        return "200";
    }

    public String delete(StoreProductCategoryRelDto.DeleteRequest request) throws Exception{
        repository.delete(repository.findByStoreProductIdAndStoreProductCategoryId(request.getStoreProductId(),request.getStoreProductCategoryId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE) ));
        return "200";
    }
}