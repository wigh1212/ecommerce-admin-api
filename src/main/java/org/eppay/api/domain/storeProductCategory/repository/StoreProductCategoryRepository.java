package org.eppay.api.domain.storeProductCategory.repository;

import org.apache.ibatis.annotations.Param;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreProductCategoryRepository extends JpaRepository<StoreProductCategoryEntity,Long> {
    @Query("SELECT s FROM StoreProductCategoryEntity s LEFT JOIN FETCH s.storeProductCategoryRelList m " +
            " LEFT JOIN FETCH m.storeProduct " +
            " WHERE s.storeId = :storeId")
    List<StoreProductCategoryEntity> findByStoreId(@Param("storeId") Long storeId);

    @Query("SELECT s FROM StoreProductCategoryEntity s LEFT JOIN FETCH s.storeProductCategoryRelList m " +
            " LEFT JOIN FETCH m.storeProduct " +
            " WHERE s.id=:id and s.storeId = :storeId")
    Optional<StoreProductCategoryEntity> findByIdAndStoreId(Long id, Long storeId);
}


