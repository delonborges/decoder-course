package com.delon.decodercourse.repositories;

import com.delon.decodercourse.entities.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {}
