package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.CourseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {

    void delete(CourseEntity courseEntity);

    void save(CourseEntity courseEntity);

    Optional<CourseEntity> findById(UUID courseId);

    List<CourseEntity> findAll();
}
