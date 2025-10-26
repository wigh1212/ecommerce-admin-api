package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryDto;
import org.eppay.api.domain.storeProductCategory.service.StoreProductCategoryService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "StoreProductCategory", description = "가맹점 상품 카테고리 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductCategoryController {

    private final StoreProductCategoryService service;

    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/product/category")
    public CommonResponse getList(StoreProductCategoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{storeId}/product/category/{id}")
    public CommonResponse getOne(StoreProductCategoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/product/category")
    public CommonResponse create(@Valid @RequestBody StoreProductCategoryDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{storeId}/product/category/{id}")
    public CommonResponse update(@Valid @RequestBody StoreProductCategoryDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/product/category/{id}")
    public CommonResponse delete( StoreProductCategoryDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
