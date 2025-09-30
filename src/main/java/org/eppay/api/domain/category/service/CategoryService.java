package org.eppay.api.domain.category.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.category.model.CategoryDto;
import org.eppay.api.domain.category.model.CategoryEntity;
import org.eppay.api.domain.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(CategoryDto.Response::fromEntity).collect(Collectors.toList());
    }

    public CategoryDto.Response getOne(CategoryDto.SearchRequest request) throws Exception{
        return CategoryDto.Response.fromEntity(repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH)));
    }

    public CategoryDto.Response create(CategoryDto.CreateRequest request) throws Exception{
        return CategoryDto.Response.fromEntity(repository.save(request.toEntity()));
    }


    public CategoryDto.Response update(CategoryDto.UpdateRequest request) throws Exception{
        CategoryEntity categoryEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE));
        request.setStatus(categoryEntity.isStatus());
        return CategoryDto.Response.fromEntity(repository.save(request.toEntity()));
    }

    public String delete(CategoryDto.DeleteRequest request) throws Exception{

        CategoryEntity categoryEntity=repository.findById(request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE));
        categoryEntity.setStatus(false);
        repository.save(categoryEntity);

        return "200";
    }

}