package org.eppay.api.domain.partner.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.partner.model.PartnerDto;
import org.eppay.api.domain.partner.model.PartnerEntity;
import org.eppay.api.domain.partner.repository.PartnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartnerService {

    private final PartnerRepository repository;
    public List<PartnerDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(PartnerDto.Response::fromEntity).collect(Collectors.toList());
    }

    public PartnerDto.Response getOne(PartnerDto.SearchRequest request) throws Exception{
        Optional<PartnerEntity> partnerOpt=repository.findById(request.getId());
        if(partnerOpt.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return PartnerDto.Response.fromEntity(partnerOpt.get());

    }

    public PartnerDto.Response create(PartnerDto.CreateRequest request) throws Exception{
        return PartnerDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public PartnerDto.Response update(PartnerDto.UpdateRequest request) throws Exception{
        Optional<PartnerEntity> partnerOpt=repository.findById(request.getId());
        if(partnerOpt.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
        return PartnerDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(PartnerDto.DeleteRequest request) throws Exception{
        Optional<PartnerEntity> partnerOpt=repository.findById(request.getId());
        if(partnerOpt.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }

        repository.delete(partnerOpt.get());

        return "200";
    }
}