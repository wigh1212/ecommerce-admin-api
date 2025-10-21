package org.eppay.api.domain.category.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.category.model.TagDto;
import org.eppay.api.domain.category.model.TagEntity;
import org.eppay.api.domain.category.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;

    public List<TagDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(TagDto.Response::fromEntity).collect(Collectors.toList());
    }

    public TagDto.Response getOne(TagDto.SearchRequest request) throws Exception{
        return TagDto.Response.fromEntity(repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }

    public TagDto.Response create(TagDto.CreateRequest request) throws Exception{
        return TagDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public TagDto.Response update(TagDto.UpdateRequest request) throws Exception{
        TagEntity categoryEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE));
        request.setStatus(categoryEntity.isStatus());
        return TagDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(TagDto.DeleteRequest request) throws Exception{

        TagEntity categoryEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE));
        categoryEntity.setStatus(false);
        repository.save(categoryEntity);

        return "200";
    }

}