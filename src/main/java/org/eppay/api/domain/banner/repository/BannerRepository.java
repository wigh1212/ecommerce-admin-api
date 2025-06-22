package org.eppay.api.domain.banner.repository;

import org.eppay.api.domain.banner.model.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity,Long> {
}


