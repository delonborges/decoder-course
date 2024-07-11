package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>, JpaSpecificationExecutor<CourseEntity> {}
