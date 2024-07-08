package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.ModuleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleService {

    void delete(ModuleEntity moduleEntity);

    void save(ModuleEntity moduleEntity);

    Optional<ModuleEntity> findModuleByCourseId(UUID moduleId, UUID courseId);

    List<ModuleEntity> findAllModulesByCourseId(UUID courseId);
}
