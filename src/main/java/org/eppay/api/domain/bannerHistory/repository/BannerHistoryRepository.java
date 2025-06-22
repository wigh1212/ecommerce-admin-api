package org.eppay.api.domain.bannerHistory.repository;

import org.eppay.api.domain.bannerHistory.model.BannerHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BannerHistoryRepository extends JpaRepository<BannerHistoryEntity,Long> {
    List<BannerHistoryEntity> findByBannerId(Long bannerId);
    Optional<BannerHistoryEntity> findByIdAndBannerId(Long id,Long bannerId);
}


