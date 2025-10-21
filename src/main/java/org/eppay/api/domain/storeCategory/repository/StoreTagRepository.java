package org.eppay.api.domain.storeCategory.repository;

import org.eppay.api.domain.storeCategory.model.StoreTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StoreTagRepository extends JpaRepository<StoreTagEntity,Long> {
    boolean existsByStoreIdAndTagId(Long storeId,Long categoryId);

    Optional<StoreTagEntity> findByStoreIdAndTagId(Long storeId,Long categoryId);
}


