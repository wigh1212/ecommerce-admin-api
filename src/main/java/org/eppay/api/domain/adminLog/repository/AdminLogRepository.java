package org.eppay.api.domain.adminLog.repository;

import org.eppay.api.domain.adminLog.model.AdminLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminLogRepository extends JpaRepository<AdminLogEntity,Long> {
}


