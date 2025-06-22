package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.service.StoreService;
import org.eppay.api.domain.user.model.UserDto;
import org.eppay.api.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{id}")
    public CommonResponse getOne(UserDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping()
    public CommonResponse create(@RequestBody UserDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{id}")
    public CommonResponse update(@RequestBody UserDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete( UserDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
