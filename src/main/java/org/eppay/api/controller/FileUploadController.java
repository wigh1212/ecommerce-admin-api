package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.SuccessCode;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.file.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Tag(name = "파일 업로드 API", description = "파일 업로드 API")
@RestController
@RequestMapping("/api/v1/file/upload")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileService service;

    @Operation(summary = "업로드", description = "업로드")
    @PostMapping()
    public CommonResponse getList(@RequestPart("file")MultipartFile file,
                                  @RequestPart("folderCode")String code) throws Exception {
        return CommonResponse.success(service.upload(file,code), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}
