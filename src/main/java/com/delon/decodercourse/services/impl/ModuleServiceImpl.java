package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.entities.ModuleEntity;
import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.repositories.ModuleRepository;
import com.delon.decodercourse.services.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    @Transactional
    public void delete(ModuleEntity moduleEntity) {
        List<LessonEntity> lessons = lessonRepository.findAllLessonsByModuleId(moduleEntity.getModuleId());
        if (!lessons.isEmpty()) {
            lessonRepository.deleteAll(lessons);
        }
        moduleRepository.delete(moduleEntity);
    }

    @Override
    public void save(ModuleEntity moduleEntity) {
        moduleRepository.save(moduleEntity);
    }

    @Override
    public Optional<ModuleEntity> findModuleByIdAndCourseId(UUID moduleId, UUID courseId) {
        return moduleRepository.findModuleByCourseId(moduleId, courseId);
    }

    @Override
    public Optional<ModuleEntity> findById(UUID moduleId) {
        return moduleRepository.findById(moduleId);
    }

    @Override
    public Page<ModuleEntity> findAllModulesByCourseId(Specification<ModuleEntity> spec, Pageable pageable) {
        return moduleRepository.findAll(spec, pageable);
    }
}
