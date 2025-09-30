package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.category.model.CategoryDto;
import org.eppay.api.domain.category.service.CategoryService;
import org.eppay.api.domain.storeCategory.model.StoreCategoryDto;
import org.eppay.api.domain.storeCategory.service.StoreCategoryService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "StoreCategory", description = "스토어 카테고리 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreCategoryController {

    private final StoreCategoryService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/category")
    public CommonResponse getList(StoreCategoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/category")
    public CommonResponse create(@RequestBody StoreCategoryDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/category/{id}")
    public CommonResponse delete( StoreCategoryDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
