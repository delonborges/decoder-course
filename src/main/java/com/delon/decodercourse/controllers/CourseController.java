package com.delon.decodercourse.controllers;

import com.delon.decodercourse.dtos.CourseDto;
import com.delon.decodercourse.entities.CourseEntity;
import com.delon.decodercourse.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable UUID courseId) {
        return courseService.findById(courseId)
                            .map(courseEntity -> ResponseEntity.status(HttpStatus.OK).body(courseEntity))
                            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<CourseEntity> saveCourse(@RequestBody @Validated CourseDto courseDto) {
        var courseEntity = CourseEntity.createFromDto(courseDto);
        courseService.save(courseEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseEntity);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable UUID courseId, @RequestBody @Validated CourseDto courseDto) {
        return courseService.findById(courseId).map(course -> {
            var courseEntity = CourseEntity.updateFromDto(courseDto);
            courseService.save(courseEntity);
            return ResponseEntity.status(HttpStatus.OK).body(courseEntity);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable UUID courseId) {
        return courseService.findById(courseId).map(course -> {
            courseService.delete(course);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
