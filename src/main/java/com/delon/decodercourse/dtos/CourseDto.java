package com.delon.decodercourse.dtos;

import com.delon.decodercourse.enums.CourseLevel;
import com.delon.decodercourse.enums.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CourseDto(@NotBlank String name,
                        @NotBlank String description,
                        String imageUrl,
                        @NotNull CourseStatus courseStatus,
                        @NotNull CourseLevel courseLevel,
                        @NotNull UUID userInstructor) {
}
