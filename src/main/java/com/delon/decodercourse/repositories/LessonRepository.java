package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, UUID>, JpaSpecificationExecutor<LessonEntity> {

    @Query(value = """
                   select * from tb_lessons
                   where module_module_id = :moduleId
                   """, nativeQuery = true)
    List<LessonEntity> findAllLessonsByModuleId(@Param("moduleId") UUID moduleId);

    @Query(value = """
                   select * from tb_lessons
                   where lesson_id = :lessonId
                   and module_module_id = :moduleId
                   """, nativeQuery = true)
    Optional<LessonEntity> findLessonByModuleId(@Param("lessonId") UUID lessonId, @Param("moduleId") UUID moduleId);
}
