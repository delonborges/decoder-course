package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.LessonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface LessonService {

    void save(LessonEntity lessonEntity);

    Optional<LessonEntity> findLessonByIdAndModuleId(UUID lessonId, UUID moduleId);

    Page<LessonEntity> findAllLessonsByModuleId(Specification<LessonEntity> and, Pageable pageable);

    void delete(LessonEntity lesson);
}
