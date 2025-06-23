package com.delon.decodercourse.entities;

import com.delon.decodercourse.dtos.ModuleDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_modules")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4468122684674095907L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID moduleId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CourseEntity course;

    @Fetch(FetchMode.SUBSELECT)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    private Set<LessonEntity> lessons;

    public static ModuleEntity createFromDto(ModuleDto moduleDto) {
        var moduleEntity = new ModuleEntity();
        BeanUtils.copyProperties(moduleDto, moduleEntity);
        setCreateAndUpdateDateTimes(moduleEntity);
        return moduleEntity;
    }

    public static ModuleEntity updateFromDto(ModuleDto moduleDto) {
        var moduleEntity = new ModuleEntity();
        BeanUtils.copyProperties(moduleDto, moduleEntity);
        moduleEntity.setUpdatedDate(LocalDateTime.now(ZoneId.of("UTC")));
        return moduleEntity;
    }

    private static void setCreateAndUpdateDateTimes(ModuleEntity moduleEntity) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        moduleEntity.setCreatedDate(now);
        moduleEntity.setUpdatedDate(now);
    }

}
