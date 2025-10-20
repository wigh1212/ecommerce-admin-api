package org.eppay.api.domain.storeProductCategoryRel.repository;

import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductCategoryRelRepository extends JpaRepository<StoreProductCategoryRelEntity,Long> {
    List<StoreProductCategoryRelEntity> findByStoreId(Long storeId);
    Optional<StoreProductCategoryRelEntity> findByIdAndStoreId(Long id, Long storeId);
    Optional<StoreProductCategoryRelEntity> findByStoreProductIdAndStoreProductCategoryId(Long storeProductId, Long storeProductCategoryId);



    boolean existsByStoreProductIdAndStoreProductCategoryId(Long storeProductId,Long storeProductCategoryId);
}


