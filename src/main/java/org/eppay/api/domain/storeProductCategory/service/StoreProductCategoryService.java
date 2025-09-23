package org.eppay.api.domain.storeProductCategory.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryDto;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryEntity;
import org.eppay.api.domain.storeProductCategory.repository.StoreProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class StoreProductCategoryService {

    private final StoreProductCategoryRepository repository;
    private final ObjectMapper objectMapper;

    public List<StoreProductCategoryDto.Response> getList(StoreProductCategoryDto.SearchRequest request) throws Exception{
        return repository.findByStoreId(request.getStoreId()).stream().map(StoreProductCategoryDto.Response::fromEntity).collect(Collectors.toList());
    }

    public StoreProductCategoryDto.Response getOne(StoreProductCategoryDto.SearchRequest request) throws Exception{
        return StoreProductCategoryDto.Response.fromEntity(repository.findByIdAndStoreId(request.getId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }


    public StoreProductCategoryDto.Response create(StoreProductCategoryDto.CreateRequest request) throws Exception{
        return StoreProductCategoryDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public StoreProductCategoryDto.Response update(StoreProductCategoryDto.UpdateRequest request) throws Exception{
        StoreProductCategoryEntity pre=repository.findByIdAndStoreId(request.getId(), request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE));

        StoreProductCategoryEntity saveStoreProductCategoryEntity=request.toEntity();
        saveStoreProductCategoryEntity.setStatus(pre.isStatus());
        saveStoreProductCategoryEntity.setStoreProductMapCategoryList(pre.getStoreProductMapCategoryList());
        return StoreProductCategoryDto.Response.fromEntity(repository.save(saveStoreProductCategoryEntity));
    }

    public String delete(StoreProductCategoryDto.DeleteRequest request) throws Exception{

        StoreProductCategoryEntity storeProductCategoryEntity=repository.findByIdAndStoreId( request.getId(),request.getStoreId()).orElseThrow(()-> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE));
        storeProductCategoryEntity.setStatus(false);
        repository.save(storeProductCategoryEntity);
        return "200";
    }
}