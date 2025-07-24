package com.delon.decodercourse.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_courses_users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseUserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8799717095056156659L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CourseEntity course;

    @Column(nullable = false)
    private UUID userId;
}
