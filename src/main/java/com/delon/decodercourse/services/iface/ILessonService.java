package com.delon.decodercourse.services.iface;

import com.delon.decodercourse.entities.LessonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ILessonService {

    void save(LessonEntity lessonEntity);

    Optional<LessonEntity> findLessonByIdAndModuleId(UUID lessonId, UUID moduleId);

    Page<LessonEntity> findAllLessonsByModuleId(Specification<LessonEntity> and, Pageable pageable);

    void delete(LessonEntity lesson);
}
