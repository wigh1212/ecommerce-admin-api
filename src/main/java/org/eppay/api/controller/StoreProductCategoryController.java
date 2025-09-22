package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryDto;
import org.eppay.api.domain.storeProductCategory.service.StoreProductCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductCategoryController {

    private final StoreProductCategoryService service;

    @GetMapping("/{storeId}/product/category")
    public CommonResponse getList(StoreProductCategoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{storeId}/product/category/{id}")
    public CommonResponse getOne(StoreProductCategoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping("/{storeId}/product/category")
    public CommonResponse create(@RequestBody StoreProductCategoryDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{storeId}/product/category/{id}")
    public CommonResponse update(@RequestBody StoreProductCategoryDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{storeId}/product/category/{id}")
    public CommonResponse delete( StoreProductCategoryDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
