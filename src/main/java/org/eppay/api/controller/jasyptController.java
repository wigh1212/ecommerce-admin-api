package org.eppay.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.response.CommonResponse;
import org.eppay.api.config.JasyptConfig;
import org.eppay.api.domain.jasypt.model.JasyptDto;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
@Tag(name = "암호화 API", description = "암호화 API")
@RestController
@RequestMapping("/api/v1/jasypt")
@RequiredArgsConstructor
public class jasyptController {

    Set<String> SENSITIVE_KEYS = Set.of("spring.datasource.password", "spring.datasource.username", "aws.s3.key", "aws.s3.secret", "stayMoa.kakao.api.addres.key");
    private final StringEncryptor encryptor;

    @Operation(summary = "암호화", description = "암호화")
    @PostMapping("enc")
    public String getEnc(@RequestBody JasyptDto.SearchRequest request ){
        return encryptor.encrypt(request.getText());
    }
    @Operation(summary = "복호화", description = "복호화")
    @PostMapping("dec")
    public String getDec(@RequestBody JasyptDto.SearchRequest request ){
        return encryptor.decrypt(request.getText());
    }
    @Operation(summary = "설정 파일 암호화", description = "설정 파일 암호화")
    @PostMapping("properties/enc")
    public String getPropertiesEnc(@RequestPart("file") MultipartFile file) throws IOException {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            StringBuilder result = new StringBuilder();

            for (String line : content.split("\n")) {
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    result.append(line).append("\n");
                    continue;
                }

                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    if (SENSITIVE_KEYS.contains(key)) {
                        String encrypted = encryptor.encrypt(value);
                        result.append(key).append("=ENC(").append(encrypted).append(")\n");
                    } else {
                        result.append(line).append("\n");
                    }
                } else {
                    result.append(line).append("\n");
                }
            }
            return result.toString();
    }
    @Operation(summary = "설정 파일 복호화", description = "설정 파일 복호화")
    @PostMapping("properties/dec")
    public String getPropertiesDec(@RequestPart("file") MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();

        for (String line : content.split("\n")) {
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                result.append(line).append("\n");
                continue;
            }

            if (line.contains("=")) {
                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (SENSITIVE_KEYS.contains(key) && value.startsWith("ENC(") && value.endsWith(")")) {
                    String encValue = value.substring(4, value.length() - 1);
                    String decrypted = encryptor.decrypt(encValue);
                    result.append(key).append("=").append(decrypted).append("\n");
                } else {
                    result.append(line).append("\n");
                }
            } else {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }
}
