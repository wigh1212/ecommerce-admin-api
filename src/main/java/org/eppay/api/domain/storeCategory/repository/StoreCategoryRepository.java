package org.eppay.api.domain.storeCategory.repository;

import org.eppay.api.domain.storeCategory.model.StoreCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreCategoryRepository extends JpaRepository<StoreCategoryEntity,Long> {
    boolean existsByStoreIdAndCategoryId(Long storeId,Long categoryId);

    Optional<StoreCategoryEntity> findByCategoryIdAndStoreId(Long categoryId,Long storeId);
}


