package org.eppay.api.domain.storeProductOptionItem.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemDto;
import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemEntity;
import org.eppay.api.domain.storeProductOptionItem.repository.StoreProductOptionItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreProductOptionItemService {

    private final StoreProductOptionItemRepository repository;
    private final ObjectMapper objectMapper;

    public List<StoreProductOptionItemDto.Response> getList(StoreProductOptionItemDto.SearchRequest request) throws Exception{
        return repository.findByStoreIdAndStoreProductOptionId(request.getStoreId(), request.getStoreProductOptionId()).stream().map(StoreProductOptionItemDto.Response::fromEntity).collect(Collectors.toList());
    }

    public StoreProductOptionItemDto.Response getOne(StoreProductOptionItemDto.SearchRequest request) throws Exception{
        return StoreProductOptionItemDto.Response.fromEntity(repository.findByIdAndStoreIdAndStoreProductOptionId(request.getId(),request.getStoreId(), request.getStoreProductOptionId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }

    public StoreProductOptionItemDto.Response create(StoreProductOptionItemDto.CreateRequest request) throws Exception{
        return StoreProductOptionItemDto.Response.fromEntity(repository.save(request.toEntity()));
    }
    public StoreProductOptionItemDto.Response update(StoreProductOptionItemDto.UpdateRequest request) throws Exception{
        StoreProductOptionItemEntity prevEntity=repository.findByIdAndStoreIdAndStoreProductOptionId(request.getId(), request.getStoreId(), request.getStoreProductOptionId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE) );
        StoreProductOptionItemEntity storeProductOptionItemEntity=request.toEntity();
        storeProductOptionItemEntity.setStoreProductOption(prevEntity.getStoreProductOption());
        return StoreProductOptionItemDto.Response.fromEntity(repository.save(storeProductOptionItemEntity));
    }
    public String delete(StoreProductOptionItemDto.DeleteRequest request) throws Exception{
        repository.delete(repository.findByIdAndStoreIdAndStoreProductOptionId( request.getId(),request.getStoreId(), request.getStoreProductOptionId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE)));
        return "200";
    }
}