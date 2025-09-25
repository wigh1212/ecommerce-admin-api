package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;
import org.eppay.api.domain.storeProductCategoryRel.service.StoreProductCategoryRelService;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;
import org.eppay.api.domain.storeProductOptionRel.service.StoreProductOptionRelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductOptionRelController {

    private final StoreProductOptionRelService service;

    @PostMapping("/{storeId}/product/option/rel")
    public CommonResponse create(@RequestBody StoreProductOptionRelDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{storeId}/product/option/rel/exist")
    public CommonResponse isExist( StoreProductOptionRelDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.isExist(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }


    @DeleteMapping("/{storeId}/product/option/rel/{id}")
    public CommonResponse delete( StoreProductOptionRelDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
