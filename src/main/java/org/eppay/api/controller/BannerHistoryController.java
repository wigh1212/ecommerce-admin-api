package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.service.BannerService;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryDto;
import org.eppay.api.domain.bannerHistory.service.BannerHistoryService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "BannerHistory", description = " 배너 조회,상세조회API")
@RestController
@RequestMapping("/api/v1/banner/{bannerId}/history")
@RequiredArgsConstructor
public class BannerHistoryController {

    private final BannerHistoryService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping()
    public CommonResponse getList(BannerHistoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{id}")
    public CommonResponse getOne(BannerHistoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
