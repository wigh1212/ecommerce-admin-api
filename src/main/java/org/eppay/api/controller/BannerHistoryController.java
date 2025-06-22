package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.service.BannerService;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryDto;
import org.eppay.api.domain.bannerHistory.service.BannerHistoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/banner/{bannerId}/history")
@RequiredArgsConstructor
public class BannerHistoryController {

    private final BannerHistoryService service;

    @GetMapping()
    public CommonResponse getList(BannerHistoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getList(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{id}")
    public CommonResponse getOne(BannerHistoryDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
