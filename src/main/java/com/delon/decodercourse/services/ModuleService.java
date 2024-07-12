package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.ModuleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ModuleService {

    void delete(ModuleEntity moduleEntity);

    void save(ModuleEntity moduleEntity);

    Optional<ModuleEntity> findModuleByIdAndCourseId(UUID moduleId, UUID courseId);

    Optional<ModuleEntity> findById(UUID moduleId);

    Page<ModuleEntity> findAllModulesByCourseId(Specification<ModuleEntity> spec, Pageable pageable);
}
