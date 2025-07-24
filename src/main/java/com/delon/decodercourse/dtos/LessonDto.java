package com.delon.decodercourse.dtos;

import jakarta.validation.constraints.NotBlank;

public record LessonDto(@NotBlank String title,
                        @NotBlank String description,
                        @NotBlank String videoUrl) {
}
