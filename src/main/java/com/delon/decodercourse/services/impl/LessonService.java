package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.services.iface.ILessonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LessonService implements ILessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void save(LessonEntity lessonEntity) {
        lessonRepository.save(lessonEntity);
    }

    @Override
    public Optional<LessonEntity> findLessonByIdAndModuleId(UUID lessonId, UUID moduleId) {
        return lessonRepository.findLessonByModuleId(lessonId, moduleId);
    }

    @Override
    public Page<LessonEntity> findAllLessonsByModuleId(Specification<LessonEntity> spec, Pageable pageable) {
        return lessonRepository.findAll(spec, pageable);
    }

    @Override
    public void delete(LessonEntity lesson) {
        lessonRepository.delete(lesson);
    }
}
