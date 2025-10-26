package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeEvent.model.StoreEventDto;
import org.eppay.api.domain.storeEvent.service.StoreEventService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "StoreEvent", description = "가맹점 이벤트 API")
@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreEventController {

    private final StoreEventService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping("/{storeId}/event")
    public CommonResponse getList(StoreEventDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{storeId}/event/{id}")
    public CommonResponse getOne(StoreEventDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "생성", description = "생성")
    @PostMapping("/{storeId}/event")
    public CommonResponse create(@Valid @RequestBody StoreEventDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{storeId}/event/{id}")
    public CommonResponse update(@Valid @RequestBody StoreEventDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{storeId}/event/{id}")
    public CommonResponse delete( StoreEventDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
