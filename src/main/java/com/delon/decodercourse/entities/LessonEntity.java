package com.delon.decodercourse.entities;

import com.delon.decodercourse.dtos.LessonDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_lessons")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7009715244752489073L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID lessonId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String videoUrl;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ModuleEntity module;

    public static LessonEntity createFromDto(LessonDto lessonDto) {
        var lessonEntity = new LessonEntity();
        BeanUtils.copyProperties(lessonDto, lessonEntity);
        setCreateAndUpdateDateTimes(lessonEntity);
        return lessonEntity;
    }

    public static LessonEntity updateFromDto(LessonDto lessonDto) {
        var lessonEntity = new LessonEntity();
        BeanUtils.copyProperties(lessonDto, lessonEntity);
        lessonEntity.setUpdatedDate(LocalDateTime.now(ZoneId.of("UTC")));
        return lessonEntity;
    }

    private static void setCreateAndUpdateDateTimes(LessonEntity lessonEntity) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        lessonEntity.setCreatedDate(now);
        lessonEntity.setUpdatedDate(now);
    }
}
