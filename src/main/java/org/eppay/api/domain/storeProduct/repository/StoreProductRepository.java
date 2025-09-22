package org.eppay.api.domain.storeProduct.repository;

import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductRepository extends JpaRepository<StoreProductEntity,Long> {
    List<StoreProductEntity> findByStoreId(Long storeId);
    Optional<StoreProductEntity> findByIdAndStoreId(Long id,Long storeId);

    List<StoreProductEntity> findAllByIdInAndStoreId(List<Long> ids, Long storeId);
}


