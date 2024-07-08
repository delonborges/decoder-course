package com.delon.decodercourse.dtos;

import jakarta.validation.constraints.NotBlank;

public record ModuleDto(@NotBlank String title,
                        @NotBlank String description) {}
