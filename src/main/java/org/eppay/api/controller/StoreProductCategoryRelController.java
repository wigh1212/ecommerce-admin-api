package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;
import org.eppay.api.domain.storeProductCategoryRel.service.StoreProductCategoryRelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductCategoryRelController {

    private final StoreProductCategoryRelService service;


    @PostMapping("/{storeId}/product/category/rel")
    public CommonResponse create(@RequestBody StoreProductCategoryRelDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }


    @DeleteMapping("/{storeId}/product/category/rel/{id}")
    public CommonResponse delete( StoreProductCategoryRelDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
