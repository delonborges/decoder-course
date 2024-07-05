package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonEntity, UUID> {}
