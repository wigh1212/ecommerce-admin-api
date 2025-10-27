package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.annotations.LogDescription;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.service.StoreService;
import org.springframework.web.bind.annotation.*;

@LogDescription("가맹점")
@Tag(name = "Store", description = "가맹점 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{id}")
    public CommonResponse getOne(StoreDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @LogDescription("생성")
    @Operation(summary = "생성", description = "생성")
    @PostMapping()
    public CommonResponse create(@Valid @RequestBody StoreDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @LogDescription("수정")
    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{id}")
    public CommonResponse update(@Valid @RequestBody StoreDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{id}")
    public CommonResponse delete( StoreDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
