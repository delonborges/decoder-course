package com.delon.decodercourse.services;

import com.delon.decodercourse.entities.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface CourseService {

    void delete(CourseEntity courseEntity);

    void save(CourseEntity courseEntity);

    Optional<CourseEntity> findById(UUID courseId);

    Page<CourseEntity> findAll(Specification<CourseEntity> spec, Pageable pageable);
}
