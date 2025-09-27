package org.eppay.api.domain.store.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginAccount;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.model.StoreEntity;
import org.eppay.api.domain.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;
    private final AdminService adminService;
    private final ObjectMapper objectMapper;
    private final LoginService loginService;

    public List<StoreDto.Response> getList() throws Exception{
        LoginAccount account=loginService.getAccount();

        if(account.getType().equals("ADMIN")){
            return repository.findAll().stream().map(StoreDto.Response::fromEntity).collect(Collectors.toList());
        }
        else if(account.getType().equals("STORE")){
            return  repository.findById(account.getStoreId()).stream().map(StoreDto.Response::fromEntity).collect(Collectors.toList());
        }

        return null;
    }

    public StoreDto.Response getOne(StoreDto.SearchRequest request) throws Exception{
        return StoreDto.Response.fromEntity(repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }


    @Transactional
    public StoreDto.Response create(StoreDto.CreateRequest request) throws Exception{
        LoginAccount account=loginService.getAccount();
        if(!account.getType().equals("ADMIN")){
            throw new BaseException(ErrorCode.ACCESS_DENIED);
        }

        if(repository.existsByBusinessNumber(request.getBusinessNumber())){
            throw new BaseException(ErrorCode.EXIST_BUSINESS_NUMBER);
        }

        StoreDto.Response saveStore=StoreDto.Response.fromEntity(repository.save(request.toEntity()));

        AdminDto.CreateRequest admin=new AdminDto.CreateRequest();
        admin.setPassword("0000");
        admin.setUserName(request.getBusinessNumber());
        admin.setType("STORE");
        admin.setName(saveStore.getCeo());
        admin.setDisplayName(saveStore.getName());
        admin.setStoreId(saveStore.getId());
        adminService.create(admin);

        return saveStore;
    }


    public StoreDto.Response update(StoreDto.UpdateRequest request) throws Exception{
        StoreEntity storeEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE));
        request.setBusinessNumber(storeEntity.getBusinessNumber());
        return StoreDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    @Transactional
    public String delete(StoreDto.DeleteRequest request) throws Exception{
        LoginAccount account=loginService.getAccount();
        if(account.getType().equals("ADMIN")){

            AdminDto.DeleteRequest adminDeleteDto=new AdminDto.DeleteRequest();
            adminDeleteDto.setStoreId(request.getId());
            adminService.deleteStore(adminDeleteDto);

            StoreEntity storeEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE));
            storeEntity.setStatus(false);
            repository.save(storeEntity);
        }
        else{
            throw new BaseException(ErrorCode.ACCESS_DENIED);
        }
        return "200";
    }

}