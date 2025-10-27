package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.annotations.LogDescription;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.adminLog.service.AdminLogService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AdminLog", description = " ip,path,param,시간 등  기록 조회 ")
@RestController
@RequestMapping("/api/v1/admin/log")
@RequiredArgsConstructor
public class AdminLogController {

    private final AdminLogService service;
    @Operation(summary = "조회", description = "조회")
    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}
