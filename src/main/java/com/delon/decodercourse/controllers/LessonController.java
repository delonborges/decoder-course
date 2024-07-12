package com.delon.decodercourse.controllers;

import com.delon.decodercourse.dtos.LessonDto;
import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.services.LessonService;
import com.delon.decodercourse.services.ModuleService;
import com.delon.decodercourse.specifications.SpecificationTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/modules/{moduleId}")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonController {

    private final LessonService lessonService;
    private final ModuleService moduleService;

    public LessonController(LessonService lessonService, ModuleService moduleService) {
        this.lessonService = lessonService;
        this.moduleService = moduleService;
    }

    @GetMapping("/lessons")
    public ResponseEntity<Page<LessonEntity>> getAllLessonsByModuleId(@PathVariable UUID moduleId,
                                                                      SpecificationTemplate.LessonSpec spec,
                                                                      @PageableDefault(sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return moduleService.findById(moduleId)
                            .map(moduleEntity -> ResponseEntity.status(HttpStatus.OK)
                                                               .body(lessonService.findAllLessonsByModuleId(SpecificationTemplate.lessonsByModuleId(moduleId).and(spec), pageable)))
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/lessons/{lessonId}")
    public ResponseEntity<Optional<LessonEntity>> getLessonByIdAndModuleId(@PathVariable UUID moduleId, @PathVariable UUID lessonId) {
        return moduleService.findById(moduleId)
                            .map(moduleEntity -> ResponseEntity.status(HttpStatus.OK).body(lessonService.findLessonByIdAndModuleId(lessonId, moduleId)))
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/lessons")
    public ResponseEntity<LessonEntity> saveLesson(@PathVariable UUID moduleId, @RequestBody @Validated LessonDto lessonDto) {
        return moduleService.findById(moduleId).map(module -> {
            var lessonEntity = LessonEntity.createFromDto(lessonDto);
            lessonEntity.setModule(module);
            lessonService.save(lessonEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(lessonEntity);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/lessons/{lessonId}")
    public ResponseEntity<LessonEntity> updateLesson(@PathVariable UUID moduleId, @PathVariable UUID lessonId, @RequestBody @Validated LessonDto lessonDto) {
        return lessonService.findLessonByIdAndModuleId(lessonId, moduleId).map(lesson -> {
            var lessonEntity = LessonEntity.updateFromDto(lessonDto);
            lessonEntity.setCreatedDate(lesson.getCreatedDate());
            lessonEntity.setModule(lesson.getModule());
            lessonService.save(lessonEntity);
            return ResponseEntity.status(HttpStatus.OK).body(lessonEntity);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/lessons/{lessonId}")
    public ResponseEntity<Object> deleteModule(@PathVariable UUID moduleId, @PathVariable UUID lessonId) {
        return lessonService.findLessonByIdAndModuleId(lessonId, moduleId).map(lesson -> {
            lessonService.delete(lesson);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
