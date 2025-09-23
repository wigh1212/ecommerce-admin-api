package org.eppay.api.domain.storeProductOption.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionDto;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;
import org.eppay.api.domain.storeProductOption.repository.StoreProductOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreProductOptionService {

    private final StoreProductOptionRepository repository;
    private final ObjectMapper objectMapper;

    public List<StoreProductOptionDto.Response> getList(StoreProductOptionDto.SearchRequest request) throws Exception{
        return repository.findByStoreId(request.getStoreId()).stream().map(StoreProductOptionDto.Response::fromEntity).collect(Collectors.toList());
    }

    public StoreProductOptionDto.Response getOne(StoreProductOptionDto.SearchRequest request) throws Exception{
        return StoreProductOptionDto.Response.fromEntity(repository.findByIdAndStoreId(request.getId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }

    public StoreProductOptionDto.Response create(StoreProductOptionDto.CreateRequest request) throws Exception{
        return StoreProductOptionDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public StoreProductOptionDto.Response update(StoreProductOptionDto.UpdateRequest request) throws Exception{
        StoreProductOptionEntity pre=repository.findByIdAndStoreId(request.getId(), request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE) );
        StoreProductOptionEntity storeProductOptionEntity=request.toEntity();
        storeProductOptionEntity.setStatus(pre.isStatus());
        storeProductOptionEntity.setStoreProductOptionRelList(pre.getStoreProductOptionRelList());
        return StoreProductOptionDto.Response.fromEntity(repository.save(storeProductOptionEntity));
    }

    public String delete(StoreProductOptionDto.DeleteRequest request) throws Exception{
        StoreProductOptionEntity storeProductEntity=repository.findByIdAndStoreId( request.getId(),request.getStoreId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE) );
        storeProductEntity.setStatus(false);
        repository.save(storeProductEntity);
        return "200";
    }
}