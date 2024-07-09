package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.LessonEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonService {

    void save(LessonEntity lessonEntity);

    Optional<LessonEntity> findLessonByIdAndModuleId(UUID lessonId, UUID moduleId);

    void delete(LessonEntity lesson);

    List<LessonEntity> findAllLessonsByModuleId(UUID moduleId);
}
