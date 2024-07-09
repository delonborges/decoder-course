package com.delon.decodercourse.controllers;

import com.delon.decodercourse.dtos.ModuleDto;
import com.delon.decodercourse.entities.ModuleEntity;
import com.delon.decodercourse.services.CourseService;
import com.delon.decodercourse.services.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses/{courseId}")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleController {

    private final ModuleService moduleService;
    private final CourseService courseService;

    public ModuleController(ModuleService moduleService, CourseService courseService) {
        this.moduleService = moduleService;
        this.courseService = courseService;
    }

    @GetMapping("/modules")
    public ResponseEntity<List<ModuleEntity>> getAllModulesByCourseId(@PathVariable UUID courseId) {
        return courseService.findById(courseId)
                            .map(courseEntity -> ResponseEntity.status(HttpStatus.OK).body(moduleService.findAllModulesByCourseId(courseId)))
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/modules/{moduleId}")
    public ResponseEntity<Optional<ModuleEntity>> getModuleByCourseIdAndId(@PathVariable UUID courseId, @PathVariable UUID moduleId) {
        return courseService.findById(courseId)
                            .map(courseEntity -> ResponseEntity.status(HttpStatus.OK).body(moduleService.findModuleByIdAndCourseId(moduleId, courseId)))
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/modules")
    public ResponseEntity<ModuleEntity> saveModule(@PathVariable UUID courseId, @RequestBody @Validated ModuleDto moduleDto) {
        return courseService.findById(courseId).map(course -> {
            var moduleEntity = ModuleEntity.createFromDto(moduleDto);
            moduleEntity.setCourse(course);
            moduleService.save(moduleEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(moduleEntity);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/modules/{moduleId}")
    public ResponseEntity<ModuleEntity> updateModule(@PathVariable UUID courseId, @PathVariable UUID moduleId, @RequestBody @Validated ModuleDto moduleDto) {
        return moduleService.findModuleByIdAndCourseId(moduleId, courseId).map(module -> {
            var moduleEntity = ModuleEntity.updateFromDto(moduleDto);
            moduleEntity.setCreatedDate(module.getCreatedDate());
            moduleEntity.setCourse(module.getCourse());
            moduleService.save(moduleEntity);
            return ResponseEntity.status(HttpStatus.OK).body(moduleEntity);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/modules/{moduleId}")
    public ResponseEntity<Object> deleteModule(@PathVariable UUID courseId, @PathVariable UUID moduleId) {
        return moduleService.findModuleByIdAndCourseId(moduleId, courseId).map(module -> {
            moduleService.delete(module);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
