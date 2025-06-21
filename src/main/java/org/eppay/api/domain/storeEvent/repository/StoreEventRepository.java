package org.eppay.api.domain.storeEvent.repository;

import org.eppay.api.domain.storeEvent.model.StoreEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreEventRepository extends JpaRepository<StoreEventEntity,Long> {
    List<StoreEventEntity> findByStoreId(Long storeId);
    Optional<StoreEventEntity> findByIdAndStoreId(Long id, Long storeId);
}


