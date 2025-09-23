package org.eppay.api.domain.partner.repository;

import org.eppay.api.domain.partner.model.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<PartnerEntity,Long> {
}


