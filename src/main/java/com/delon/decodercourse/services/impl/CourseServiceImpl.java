package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.entities.CourseEntity;
import com.delon.decodercourse.repositories.CourseRepository;
import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.repositories.ModuleRepository;
import com.delon.decodercourse.services.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public CourseServiceImpl(CourseRepository courseRepository, ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    @Transactional
    public void delete(CourseEntity courseEntity) {
        Optional.of(moduleRepository.findAllModulesByCourseId(courseEntity.getCourseId())).ifPresent(modules -> {
            modules.forEach(module -> Optional.of(lessonRepository.findAllLessonsByModuleId(module.getModuleId())).ifPresent(lessonRepository::deleteAll));
            moduleRepository.deleteAll(modules);
        });
        courseRepository.delete(courseEntity);
    }

    @Override
    public void save(CourseEntity courseEntity) {
        courseRepository.save(courseEntity);
    }

    @Override
    public Optional<CourseEntity> findById(UUID courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }
}
