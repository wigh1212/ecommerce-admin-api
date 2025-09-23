package org.eppay.api.domain.storeProductOption.repository;

import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductOptionRepository extends JpaRepository<StoreProductOptionEntity,Long> {
    List<StoreProductOptionEntity> findByStoreId(Long storeId);
    Optional<StoreProductOptionEntity> findByIdAndStoreId(Long id, Long storeId);
}


