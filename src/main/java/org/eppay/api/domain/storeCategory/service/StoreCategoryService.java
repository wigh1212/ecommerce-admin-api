package org.eppay.api.domain.storeCategory.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.domain.category.model.CategoryEntity;
import org.eppay.api.domain.category.repository.CategoryRepository;
import org.eppay.api.domain.storeCategory.model.StoreCategoryDto;
import org.eppay.api.domain.storeCategory.model.StoreCategoryEntity;
import org.eppay.api.domain.storeCategory.repository.StoreCategoryRepository;
import org.eppay.api.domain.storeProduct.model.StoreProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCategoryService {

    private final StoreCategoryRepository storeCategoryRepository;

    private final CategoryRepository categoryRepository;

    public List<StoreCategoryDto.CustomResponse> getList(StoreCategoryDto.SearchRequest request) throws Exception{
        List<StoreCategoryDto.CustomResponse> list=categoryRepository.findByStatus(true).stream().map(StoreCategoryDto.CustomResponse::fromEntity).collect(Collectors.toList());
        if(request.getStoreId()!=null){
            for (StoreCategoryDto.CustomResponse response : list) {
                response.setExists(storeCategoryRepository.existsByStoreIdAndCategoryId(request.getStoreId(), response.getId()));
            }
        }
        return list;
    }

    public StoreCategoryDto.Response create(StoreCategoryDto.CreateRequest request) throws Exception{
        CategoryEntity categoryEntity= categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH));
        request.setCategoryName(categoryEntity.getName());
        return StoreCategoryDto.Response.fromEntity(storeCategoryRepository.save(request.toEntity()));
    }

    public String delete(StoreCategoryDto.DeleteRequest request) throws Exception{
        storeCategoryRepository.delete(storeCategoryRepository.findByCategoryIdAndStoreId(request.getStoreId(),request.getId()).orElseThrow(() -> new BaseException(ErrorCode.RESPONSE_FAIL_DELETE)));
        return "200";
    }

}