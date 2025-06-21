package org.eppay.api.domain.file.service;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.entity.mime.MultipartPart;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.enums.FolderEnum;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginAccount;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.config.S3Config;
import org.eppay.api.domain.admin.model.AdminDto;
import org.eppay.api.domain.admin.service.AdminService;
import org.eppay.api.domain.file.model.FileDto;
import org.eppay.api.domain.store.model.StoreDto;
import org.eppay.api.domain.store.model.StoreEntity;
import org.eppay.api.domain.store.repository.StoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {
    private final S3Config s3Config;

    private final ModelMapper modelMapper;
//    public FileDto upload(MultipartFile file){
//
//
//
//
//
//        return modelMapper.map(file, FileDto.class);
//    }


    public FileDto upload(MultipartFile multipartFile, String code) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        String fileExtension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";

        String dirName= FolderEnum.get(code);

        String fileName = dirName + "/" + UUID.randomUUID() + fileExtension;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        AmazonS3Client s3Client=s3Config.amazonS3Client();

        s3Client.putObject(s3Config.getBucket(), fileName, multipartFile.getInputStream(), metadata);

        FileDto file=modelMapper.map(multipartFile, FileDto.class);
        file.setImagePath(s3Client.getUrl(s3Config.getBucket(), fileName).toString());
        return file;
    }

}