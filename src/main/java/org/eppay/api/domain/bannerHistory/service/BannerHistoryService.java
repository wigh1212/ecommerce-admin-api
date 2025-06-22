package org.eppay.api.domain.bannerHistory.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.domain.banner.model.BannerDto;
import org.eppay.api.domain.banner.model.BannerEntity;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryDto;
import org.eppay.api.domain.bannerHistory.model.BannerHistoryEntity;
import org.eppay.api.domain.bannerHistory.repository.BannerHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerHistoryService {
    private final LoginService loginService;
    private final BannerHistoryRepository repository;


    public List<BannerHistoryDto.Response> getList(BannerHistoryDto.SearchRequest request) throws Exception{
        return repository.findByBannerId(request.getBannerId()).stream().map(BannerHistoryDto.Response::fromEntity).collect(Collectors.toList());
    }

    public BannerHistoryDto.Response getOne(BannerHistoryDto.SearchRequest request) throws Exception{
        Optional<BannerHistoryEntity> optional=repository.findByIdAndBannerId(request.getId(),request.getBannerId());
        if(optional.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return BannerHistoryDto.Response.fromEntity(optional.get());
    }



    public void init(BannerEntity banner){
        BannerHistoryEntity bannerHistory=new BannerHistoryEntity();
        bannerHistory.setBannerId(banner.getId());
        bannerHistory.setImage(banner.getImage());
        bannerHistory.setLink(banner.getLink());
        bannerHistory.setActivate(banner.isActivate());
        bannerHistory.setApplyBy(banner.getApplyBy());
        bannerHistory.setApplyAt(banner.getApplyAt());
        repository.save(bannerHistory);
    }
}