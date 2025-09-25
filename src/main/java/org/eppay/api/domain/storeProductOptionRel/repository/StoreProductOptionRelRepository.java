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

    boolean existsByStoreProductIdAndStoreProductOptionId(Long storeProductId, Long storeProductOptionId);

    Optional<StoreProductOptionRelEntity> findByStoreProductIdAndStoreProductOptionId(Long storeProductId, Long storeProductOptionId);

}


