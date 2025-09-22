package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryDto;
import org.eppay.api.domain.storeProductCategory.service.StoreProductCategoryService;
import org.eppay.api.domain.storeProductMapCategory.model.StoreProductMapCategoryDto;
import org.eppay.api.domain.storeProductMapCategory.service.StoreProductMapCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductMapCategoryController {

    private final StoreProductMapCategoryService service;


    @PostMapping("/{storeId}/product/map/category")
    public CommonResponse create(@RequestBody StoreProductMapCategoryDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }


    @DeleteMapping("/{storeId}/product/map/category/{id}")
    public CommonResponse delete( StoreProductMapCategoryDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
