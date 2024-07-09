package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.services.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
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
    public void delete(LessonEntity lesson) {
        lessonRepository.delete(lesson);
    }

    @Override
    public List<LessonEntity> findAllLessonsByModuleId(UUID moduleId) {
        return lessonRepository.findAllLessonsByModuleId(moduleId);
    }
}
