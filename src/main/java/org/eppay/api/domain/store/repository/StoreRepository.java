package org.eppay.api.domain.store.repository;

import org.apache.ibatis.annotations.Param;
import org.eppay.api.domain.store.model.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StoreRepository extends JpaRepository<StoreEntity,Long> {
    Optional<StoreEntity> findByBusinessNumber(String businessNumber);
}


