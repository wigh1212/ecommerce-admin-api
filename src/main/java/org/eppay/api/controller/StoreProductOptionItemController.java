package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionDto;
import org.eppay.api.domain.storeProductOption.service.StoreProductOptionService;
import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemDto;
import org.eppay.api.domain.storeProductOptionItem.service.StoreProductOptionItemService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "StoreProductOptionItem", description = "가맹점 상품 옵션 아이템 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductOptionItemController {

    private final StoreProductOptionItemService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/product/option/{storeProductOptionId}/item")
    public CommonResponse getList(StoreProductOptionItemDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{storeId}/product/option/{storeProductOptionId}/item/{id}")
    public CommonResponse getOne(StoreProductOptionItemDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/product/option/{storeProductOptionId}/item")
    public CommonResponse create(@RequestBody StoreProductOptionItemDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{storeId}/product/option/{storeProductOptionId}/item/{id}")
    public CommonResponse update(@RequestBody StoreProductOptionItemDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/product/option/{storeProductOptionId}/item/{id}")
    public CommonResponse delete( StoreProductOptionItemDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
