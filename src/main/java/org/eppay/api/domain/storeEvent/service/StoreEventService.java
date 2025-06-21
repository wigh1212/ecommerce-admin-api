package org.eppay.api.domain.storeEvent.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.storeEvent.model.StoreEventDto;
import org.eppay.api.domain.storeEvent.model.StoreEventEntity;
import org.eppay.api.domain.storeEvent.repository.StoreEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreEventService {

    private final StoreEventRepository repository;
    private final ObjectMapper objectMapper;

    public List<StoreEventDto.Response> getList(StoreEventDto.SearchRequest request) throws Exception{
        return repository.findByStoreId(request.getStoreId()).stream().map(StoreEventDto.Response::fromEntity).collect(Collectors.toList());
    }

    public StoreEventDto.Response getOne(StoreEventDto.SearchRequest request) throws Exception{
        Optional<StoreEventEntity> optional=repository.findByIdAndStoreId(request.getId(),request.getStoreId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return StoreEventDto.Response.fromEntity(optional.get());
    }


    public StoreEventDto.Response create(StoreEventDto.CreateRequest request) throws Exception{
        return StoreEventDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public StoreEventDto.Response update(StoreEventDto.UpdateRequest request) throws Exception{
        Optional<StoreEventEntity> optional=repository.findByIdAndStoreId(request.getId(), request.getStoreId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
        return StoreEventDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(StoreEventDto.DeleteRequest request) throws Exception{

        System.out.println("id:"+request.getId()+"storeid:"+request.getStoreId());

        Optional<StoreEventEntity> optional=repository.findByIdAndStoreId( request.getId(),request.getStoreId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }

        repository.delete(optional.get());

        return "200";
    }
}