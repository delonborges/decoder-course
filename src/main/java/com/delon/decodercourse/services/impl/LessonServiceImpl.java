package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.services.LessonService;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
}
