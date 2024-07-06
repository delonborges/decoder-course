package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {

    @Query(value = """
                   select * from tb_module
                   where course_course_id = :courseId
                   """, nativeQuery = true)
    List<ModuleEntity> findAllModulesByCourseId(@Param("courseId") UUID courseId);
}
