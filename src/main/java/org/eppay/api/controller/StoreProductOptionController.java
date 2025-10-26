package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionDto;
import org.eppay.api.domain.storeProductOption.service.StoreProductOptionService;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelDto;
import org.springframework.web.bind.annotation.*;
@Tag(name = "StoreProductOption", description = "가맹점 상품 옵션 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductOptionController {

    private final StoreProductOptionService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/product/option")
    public CommonResponse getList(StoreProductOptionDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{storeId}/product/option/{id}")
    public CommonResponse getOne(StoreProductOptionDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/product/option")
    public CommonResponse create(@Valid @RequestBody StoreProductOptionDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{storeId}/product/option/{id}")
    public CommonResponse update(@Valid @RequestBody StoreProductOptionDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "제거", description = "제거")
    @DeleteMapping("/{storeId}/product/option/{id}")
    public CommonResponse delete( StoreProductOptionDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
