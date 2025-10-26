package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.service.StoreService;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.eppay.api.domain.storeProduct.service.StoreProductService;
import org.springframework.web.bind.annotation.*;


@Tag(name = "StoreProduct", description = "가맹점 상품 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreProductController {

    private final StoreProductService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/product")
    public CommonResponse getList(StoreProductDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{storeId}/product/{id}")
    public CommonResponse getOne(StoreProductDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/product")
    public CommonResponse create(@Valid @RequestBody StoreProductDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{storeId}/product/{id}")
    public CommonResponse update(@Valid @RequestBody StoreProductDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

//    @Operation(summary = "삭제", description = "삭제")
//    @DeleteMapping("/{storeId}/product/{id}")
//    public CommonResponse delete( StoreProductDto.DeleteRequest request) throws Exception {
//        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
//    }

    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/product/{id}")
    public CommonResponse delete( StoreProductDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
