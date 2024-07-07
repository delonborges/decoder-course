package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.entities.ModuleEntity;
import com.delon.decodercourse.repositories.LessonRepository;
import com.delon.decodercourse.repositories.ModuleRepository;
import com.delon.decodercourse.services.ModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    @Transactional
    public void delete(ModuleEntity moduleEntity) {
        List<LessonEntity> lessons = lessonRepository.findAllLessonsByModuleId(moduleEntity.getModuleId());
        if (!lessons.isEmpty()) {
            lessonRepository.deleteAll(lessons);
        }
        moduleRepository.delete(moduleEntity);
    }
}
