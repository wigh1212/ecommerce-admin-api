package org.eppay.api.domain.category.repository;

import org.eppay.api.domain.category.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Long> {
    List<TagEntity> findByStatus(boolean status);
}


