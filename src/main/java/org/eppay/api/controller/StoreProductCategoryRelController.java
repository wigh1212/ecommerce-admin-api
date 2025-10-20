package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelDto;
import org.eppay.api.domain.storeProductCategoryRel.service.StoreProductCategoryRelService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "StoreProductCategoryRel", description = "가맹점 상품 카테고리 매핑 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductCategoryRelController {

    private final StoreProductCategoryRelService service;

    @Operation(summary = "매핑", description = "매핑")
    @PostMapping("/{storeId}/product/category/rel")
    public CommonResponse create(@RequestBody StoreProductCategoryRelDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/product/category/rel")
    public CommonResponse delete( StoreProductCategoryRelDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
