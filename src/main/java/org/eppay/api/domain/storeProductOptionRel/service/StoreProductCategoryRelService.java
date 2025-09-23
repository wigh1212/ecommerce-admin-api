package org.eppay.api.domain.storeProductOptionRel.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.storeProduct.repository.StoreProductRepository;
import org.eppay.api.domain.storeProductOption.repository.StoreProductOptionRepository;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;
import org.eppay.api.domain.storeProductOptionRel.repository.StoreProductOptionRelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreProductCategoryRelService {

    private final StoreProductOptionRelRepository repository;
    private final StoreProductOptionRepository storeProductCategoryRepository;
    private final StoreProductRepository storeProductRepository;

    private final ObjectMapper objectMapper;

    @Transactional
    public String create(StoreProductOptionRelDto.CreateRequest request) throws Exception{

//        StoreProductCategoryEntity storeProductCategoryEntity=storeProductCategoryRepository.findById(request.getStoreProductCategoryId()).orElseThrow(() -> new BaseException(ErrorCode.NOT_EXIST_CATEGORY_ID));
//
//        storeProductCategoryEntity.removeAllProducts();
//
//        List<StoreProductEntity> products = storeProductRepository.findAllByIdInAndStoreId(request.getStoreProductIdList(), storeProductCategoryEntity.getStoreId());
//
//        products.forEach(storeProductCategoryEntity::addProduct);

        return "200";
    }

    public String delete(StoreProductOptionRelDto.DeleteRequest request) throws Exception{
//        Optional<StoreProductCategoryRelEntity> optional=repository.findByIdAndStoreId( request.getId(),request.getStoreId());
//        if(optional.isEmpty()){
//            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
//        }
//        repository.delete(optional.get());

        return "200";
    }
}