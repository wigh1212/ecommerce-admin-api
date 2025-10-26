package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeCategory.model.StoreTagDto;
import org.eppay.api.domain.storeCategory.service.StoreTagService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "StoreTag", description = "스토어 태그 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreTagController {

    private final StoreTagService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/tag")
    public CommonResponse getList(StoreTagDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/tag")
    public CommonResponse create(@Valid @RequestBody StoreTagDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/tag/{tegId}")
    public CommonResponse delete( StoreTagDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
