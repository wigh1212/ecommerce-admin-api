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

        StoreProductCategoryEntity storeProductCategoryEntity=storeProductCategoryRepository.findById(request.getStoreProductCategoryId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_CATEGORY_ID));

        storeProductCategoryEntity.removeAllProducts();

        List<StoreProductEntity> products = storeProductRepository.findAllByIdInAndStoreId(request.getStoreProductIdList(), storeProductCategoryEntity.getStoreId());

        products.forEach(storeProductCategoryEntity::addProduct);

        return "200";
    }

    public String delete(StoreProductCategoryRelDto.DeleteRequest request) throws Exception{
        Optional<StoreProductCategoryRelEntity> optional=repository.findByIdAndStoreId( request.getId(),request.getStoreId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        repository.delete(optional.get());

        return "200";
    }
}