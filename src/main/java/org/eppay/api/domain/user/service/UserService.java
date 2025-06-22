package org.eppay.api.domain.user.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginAccount;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.user.model.UserDto;
import org.eppay.api.domain.user.model.UserEntity;
import org.eppay.api.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    public List<UserDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(UserDto.Response::fromEntity).collect(Collectors.toList());
    }

    public UserDto.Response getOne(UserDto.SearchRequest request) throws Exception{
        Optional<UserEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return UserDto.Response.fromEntity(optional.get());
    }


    public UserDto.Response create(UserDto.CreateRequest request) throws Exception{
        return UserDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public UserDto.Response update(UserDto.UpdateRequest request) throws Exception{
        Optional<UserEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
        request.setUserName(optional.get().getUserName());
        request.setPassword(optional.get().getPassword());
        return UserDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(UserDto.DeleteRequest request) throws Exception{
        Optional<UserEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }

        repository.delete(optional.get());

        return "200";
    }
}