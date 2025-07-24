package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID>, JpaSpecificationExecutor<ModuleEntity> {

    @Query(value = """
                   select * from tb_modules
                   where course_course_id = :courseId
                   """, nativeQuery = true)
    List<ModuleEntity> findAllModulesByCourseId(@Param("courseId") UUID courseId);

    @Query(value = """
                   select * from tb_modules
                   where course_course_id = :courseId
                   and module_id = :moduleId
                   """, nativeQuery = true)
    Optional<ModuleEntity> findModuleByCourseId(@Param("moduleId") UUID moduleId, @Param("courseId") UUID courseId);
}
