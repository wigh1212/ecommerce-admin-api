package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.storeEvent.model.StoreEventDto;
import org.eppay.api.domain.storeEvent.service.StoreEventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreEventController {

    private final StoreEventService service;

    @GetMapping("/{storeId}/event")
    public CommonResponse getList(StoreEventDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{storeId}/event/{id}")
    public CommonResponse getOne(StoreEventDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping("/{storeId}/event")
    public CommonResponse create(@RequestBody StoreEventDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PutMapping("/{storeId}/event/{id}")
    public CommonResponse update(@RequestBody StoreEventDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{storeId}/event/{id}")
    public CommonResponse delete( StoreEventDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
