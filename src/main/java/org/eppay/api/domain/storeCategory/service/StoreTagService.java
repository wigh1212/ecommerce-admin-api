package org.eppay.api.domain.storeCategory.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.category.model.TagEntity;
import org.eppay.api.domain.category.repository.TagRepository;
import org.eppay.api.domain.storeCategory.model.StoreTagDto;
import org.eppay.api.domain.storeCategory.repository.StoreTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreTagService {

    private final StoreTagRepository storeCategoryRepository;

    private final TagRepository categoryRepository;

    public List<StoreTagDto.CustomResponse> getList(StoreTagDto.SearchRequest request) throws Exception{
        List<StoreTagDto.CustomResponse> list=categoryRepository.findByStatus(true).stream().map(StoreTagDto.CustomResponse::fromEntity).collect(Collectors.toList());
        if(request.getStoreId()!=null){
            for (StoreTagDto.CustomResponse response : list) {
                response.setExists(storeCategoryRepository.existsByStoreIdAndTagId(request.getStoreId(), response.getId()));
            }
        }
        return list;
    }

    public StoreTagDto.Response create(StoreTagDto.CreateRequest request) throws Exception{
        TagEntity categoryEntity= categoryRepository.findById(request.getTagId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH));
        request.setTagName(categoryEntity.getName());
        return StoreTagDto.Response.fromEntity(storeCategoryRepository.save(request.toEntity()));
    }

    public String delete(StoreTagDto.DeleteRequest request) throws Exception{
        storeCategoryRepository.delete(storeCategoryRepository.findByStoreIdAndTagId(request.getStoreId(),request.getTegId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE)));
        return "200";
    }

}