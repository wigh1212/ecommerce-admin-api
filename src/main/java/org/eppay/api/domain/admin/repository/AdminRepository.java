package org.eppay.api.domain.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.eppay.api.domain.admin.model.AdminEntity;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

    public Optional<AdminEntity> findByUserName(String username);
    public Optional<AdminEntity> findByName(String name);
    public boolean deleteByUserName(String username);
}


