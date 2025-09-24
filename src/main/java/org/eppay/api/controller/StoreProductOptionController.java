package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionDto;
import org.eppay.api.domain.storeProductOption.service.StoreProductOptionService;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductOptionController {

    private final StoreProductOptionService service;

    @GetMapping("/{storeId}/product/option")
    public CommonResponse getList(StoreProductOptionDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{storeId}/product/option/{id}")
    public CommonResponse getOne(StoreProductOptionDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping("/{storeId}/product/option")
    public CommonResponse create(@RequestBody StoreProductOptionDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{storeId}/product/option/{id}")
    public CommonResponse update(@RequestBody StoreProductOptionDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{storeId}/product/option/{id}")
    public CommonResponse delete( StoreProductOptionDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
