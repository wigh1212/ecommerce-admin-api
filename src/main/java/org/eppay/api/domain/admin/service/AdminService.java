package org.eppay.api.domain.admin.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.model.AdminEntity;
import org.eppay.api.domain.admin.repository.AdminRepository;
import org.eppay.api.util.Sha256Helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;
//    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public List<AdminDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(AdminDto.Response::fromEntity).collect(Collectors.toList());
    }

    public AdminDto.Response getOne(AdminDto.SearchRequest request) throws Exception{
        Optional<AdminEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        } 
        return AdminDto.Response.fromEntity(optional.get());
    }


    public AdminDto.Response create(AdminDto.CreateRequest request) throws Exception{

        Optional<AdminEntity> optional = repository.findByUserName(request.getName());
        if(optional.isPresent()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_INSERT);
        }
        return AdminDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public AdminDto.Response update(AdminDto.UpdateRequest request) throws Exception{
        Optional<AdminEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
        AdminEntity entity=optional.get();
        request.setUserName(entity.getUsername());

        return AdminDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(AdminDto.DeleteRequest request) throws Exception{

        Optional<AdminEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }

        repository.delete(optional.get());

        return "200";
    }


}