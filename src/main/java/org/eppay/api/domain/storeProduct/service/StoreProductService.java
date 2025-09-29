package org.eppay.api.domain.storeProduct.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProduct.repository.StoreProductRepository;
import org.eppay.api.domain.storeProductCategoryRel.repository.StoreProductCategoryRelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreProductService {

    private final StoreProductRepository repository;
    private final StoreProductCategoryRelRepository storeProductCategoryRelRepository;
    private final ObjectMapper objectMapper;

    public List<StoreProductDto.Response> getList(StoreProductDto.SearchRequest request) throws Exception{
        List<StoreProductDto.Response> list=repository.findByStoreId(request.getStoreId()).stream().map(StoreProductDto.Response::fromEntity).toList();
        if(request.getStoreProductCategoryId()!=null){
            for (StoreProductDto.Response response : list) {
                response.setExistCategory(storeProductCategoryRelRepository.existsByStoreProductIdAndStoreProductCategoryId(response.getId(), request.getStoreProductCategoryId()));
            }
        }
        return list;
    }

    public StoreProductDto.Response getOne(StoreProductDto.SearchRequest request) throws Exception{
        return StoreProductDto.Response.fromEntity(repository.findByIdAndStoreId(request.getId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }


    public StoreProductDto.Response create(StoreProductDto.CreateRequest request) throws Exception{
        return StoreProductDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public StoreProductDto.Response update(StoreProductDto.UpdateRequest request) throws Exception{
        StoreProductEntity pre=repository.findByIdAndStoreId(request.getId(), request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE) );
        StoreProductEntity save=request.toEntity();
        save.setStatus(pre.isStatus());
        save.setStoreProductCategoryRelList(pre.getStoreProductCategoryRelList());
        save.setStoreProductOptionRelList(pre.getStoreProductOptionRelList());
        return StoreProductDto.Response.fromEntity(repository.save(save));
    }

    public String delete(StoreProductDto.DeleteRequest request) throws Exception{
        StoreProductEntity storeProductEntity=repository.findByIdAndStoreId( request.getId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE) );
        storeProductEntity.setStatus(false);
        repository.save(storeProductEntity);
        return "200";
    }
}