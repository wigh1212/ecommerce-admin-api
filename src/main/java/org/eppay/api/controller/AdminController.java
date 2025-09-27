package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.springframework.web.bind.annotation.*;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;

@Tag(name = "Admin", description = "어드민 조회,상세조회,로그인 api")
@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

//    @GetMapping()
//    public CommonResponse getList() throws Exception {
//        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }
//
//    @GetMapping("/{id}")
//    public CommonResponse getOne(AdminDto.SearchRequest request) throws Exception {
//        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }

//    @PostMapping()
//    public CommonResponse create(@RequestBody AdminDto.CreateRequest request) throws Exception {
//        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }
//
//    @PutMapping("/{id}")
//    public CommonResponse update(@RequestBody AdminDto.UpdateRequest request) throws Exception {
//        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }

//    @DeleteMapping("/{id}")
//    public CommonResponse delete( AdminDto.DeleteRequest request) throws Exception {
//        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/login")
    public CommonResponse login(@RequestBody AdminDto.login request) throws Exception {
        return CommonResponse.success(service.login(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}
