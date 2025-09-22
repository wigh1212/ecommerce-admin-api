package org.eppay.api.domain.storeProductMapCategory.repository;

import org.eppay.api.domain.storeProductMapCategory.model.StoreProductMapCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductMapCategoryRepository extends JpaRepository<StoreProductMapCategoryEntity,Long> {
    List<StoreProductMapCategoryEntity> findByStoreId(Long storeId);
    Optional<StoreProductMapCategoryEntity> findByIdAndStoreId(Long id, Long storeId);
    Optional<StoreProductMapCategoryEntity> findByStoreProductIdAndStoreProductCategoryId(Long storeProductId, Long storeProductCategoryId);

}


