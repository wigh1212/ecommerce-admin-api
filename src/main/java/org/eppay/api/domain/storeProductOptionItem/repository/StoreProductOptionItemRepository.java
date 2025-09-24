package org.eppay.api.domain.storeProductOptionItem.repository;

import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductOptionItemRepository extends JpaRepository<StoreProductOptionItemEntity,Long> {
    List<StoreProductOptionItemEntity> findByStoreIdAndStoreProductOptionId(Long storeId,Long storeProductOptionId);
    Optional<StoreProductOptionItemEntity> findByIdAndStoreIdAndStoreProductOptionId(Long id,Long storeId,Long storeProductOptionId);
}


