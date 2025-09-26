package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.service.BannerService;
import org.springframework.web.bind.annotation.*;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;

@Tag(name = "배너 API", description = " 배너 조회,상세조회,생성,수정,삭제 API")
@RestController
@RequestMapping("/api/v1/banner")
@RequiredArgsConstructor
public class BannerController {

    private final BannerService service;

    @Operation(summary = "조회", description = "조회")
    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "상세 조회", description = "상세 조회")
    @GetMapping("/{id}")
    public CommonResponse getOne(BannerDto.SearchRequest request) throws Exception {
        return CommonResponse.success(service.getOne(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "생성", description = "생성")
    @PostMapping()
    public CommonResponse create(@RequestBody BannerDto.CreateRequest request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "수정", description = "수정")
    @PutMapping("/{id}")
    public CommonResponse update(@RequestBody BannerDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @Operation(summary = "삭제", description = "삭제")
    @DeleteMapping("/{id}")
    public CommonResponse delete( BannerDto.DeleteRequest request) throws Exception {
        return CommonResponse.success(service.delete(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
