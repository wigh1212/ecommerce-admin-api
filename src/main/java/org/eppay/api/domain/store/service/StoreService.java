package org.eppay.api.domain.store.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.model.StoreEntity;
import org.eppay.api.domain.store.repository.StoreRepository;
import org.eppay.api.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;


    public List<StoreDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(StoreDto.Response::fromEntity).collect(Collectors.toList());
    }

    public StoreDto.Response getOne(StoreDto.SearchRequest request) throws Exception{
        Optional<StoreEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return StoreDto.Response.fromEntity(optional.get());
    }


    public StoreDto.Response create(StoreDto.CreateRequest request) throws Exception{
        Optional<StoreEntity> optional = repository.findByBusinessNumber(request.getBusinessNumber());
        if(optional.isPresent()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_INSERT);
        }

        return StoreDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public StoreDto.Response update(StoreDto.UpdateRequest request) throws Exception{
        Optional<StoreEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
        StoreEntity entity=optional.get();
        request.setBusinessNumber(entity.getBusinessNumber());

        return StoreDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(StoreDto.DeleteRequest request) throws Exception{

        Optional<StoreEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }

        repository.delete(optional.get());

        return "200";
    }
}