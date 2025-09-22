package org.eppay.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.service.StoreService;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductController {

    private final StoreProductService service;

    @GetMapping("/{storeId}/product")
    public CommonResponse getList(StoreProductDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{storeId}/product/{id}")
    public CommonResponse getOne(StoreProductDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping("/{storeId}/product")
    public CommonResponse create(@RequestBody StoreProductDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{storeId}/product/{id}")
    public CommonResponse update(@RequestBody StoreProductDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{storeId}/product/{id}")
    public CommonResponse delete( StoreProductDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
