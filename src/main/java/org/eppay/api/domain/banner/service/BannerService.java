package org.eppay.api.domain.banner.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginAccount;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.model.BannerEntity;
import org.eppay.api.domain.banner.repository.BannerRepository;
import org.eppay.api.domain.bannerHistory.service.BannerHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerService {
    private final LoginService loginService;
    private final BannerRepository repository;
    private final BannerHistoryService bannerHistoryService;
    public List<BannerDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(BannerDto.Response::fromEntity).collect(Collectors.toList());
    }

    public BannerDto.Response getOne(BannerDto.SearchRequest request) throws Exception{
        Optional<BannerEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }

        return BannerDto.Response.fromEntity(optional.get());
    }


    public BannerDto.Response create(BannerDto.CreateRequest request) throws Exception{
        LoginAccount account=loginService.getAccount();

        request.setActivate(true);
        request.setApplyAt(LocalDateTime.now());
        request.setApplyBy(account.getUsername());


        BannerEntity banner=repository.save(request.toEntity());

        bannerHistoryService.init(banner);

        return BannerDto.Response.fromEntity(repository.save(banner));
    }

    public BannerDto.Response update(BannerDto.UpdateRequest request) throws Exception{
        Optional<BannerEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        BannerEntity entity=optional.get();

        request.setApplyAt(entity.getApplyAt());
        request.setApplyBy(entity.getApplyBy());
        request.setActivate(entity.isActivate());


        BannerEntity banner=repository.save(request.toEntity());

        bannerHistoryService.init(banner);

        return BannerDto.Response.fromEntity(banner);
    }

    public BannerDto.Response delete(BannerDto.DeleteRequest request) throws Exception{
        Optional<BannerEntity> optional=repository.findById(request.getId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        BannerEntity banner=optional.get();

        if(banner.isActivate()){
            banner.setActivate(false);
        }
        else{
            LoginAccount account=loginService.getAccount();
            banner.setActivate(true);
            banner.setApplyBy(account.getUsername());
            banner.setApplyAt(LocalDateTime.now());
        }

        banner=repository.save(banner);

        bannerHistoryService.init(banner);

        return BannerDto.Response.fromEntity(banner);
    }
}