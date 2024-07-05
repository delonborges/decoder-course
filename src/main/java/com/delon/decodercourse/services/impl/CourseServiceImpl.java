package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.repositories.CourseRepository;
import com.delon.decodercourse.services.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
