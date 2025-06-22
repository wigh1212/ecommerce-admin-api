package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.service.BannerService;
import org.springframework.web.bind.annotation.*;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;

@RestController
@RequestMapping("/api/v1/banner")
@RequiredArgsConstructor
public class BannerController {

    private final BannerService service;

    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{id}")
    public CommonResponse getOne(BannerDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping()
    public CommonResponse create(@RequestBody BannerDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{id}")
    public CommonResponse update(@RequestBody BannerDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete( BannerDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
