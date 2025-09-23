package org.eppay.api.domain.storeProductOptionRel.repository;

import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductOptionRelRepository extends JpaRepository<StoreProductOptionRelEntity,Long> {
    List<StoreProductOptionRelEntity> findByStoreId(Long storeId);
    Optional<StoreProductOptionRelEntity> findByIdAndStoreId(Long id, Long storeId);
    Optional<StoreProductOptionRelEntity> findByStoreProductIdAndStoreProductCategoryId(Long storeProductId, Long storeProductCategoryId);

}


