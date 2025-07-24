package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.CourseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseUserRepository extends JpaRepository<CourseUserEntity, UUID> {
}
