package com.delon.decodercourse.specifications;

import com.delon.decodercourse.entities.CourseEntity;
import com.delon.decodercourse.entities.LessonEntity;
import com.delon.decodercourse.entities.ModuleEntity;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.UUID;

public class SpecificationTemplate {

    public static Specification<ModuleEntity> modulesByCourseId(final UUID courseId) {
        return ((root, query, criteriaBuilder) -> {
            query.distinct(true);
            Root<CourseEntity> course = query.from(CourseEntity.class);
            Expression<Collection<ModuleEntity>> modules = course.get("modules");
            return criteriaBuilder.and(criteriaBuilder.equal(course.get("courseId"), courseId), criteriaBuilder.isMember(root, modules));
        });
    }

    @And({@Spec(path = "courseLevel", spec = Equal.class),
          @Spec(path = "courseStatus", spec = Equal.class),
          @Spec(path = "name", spec = Like.class)})
    public interface CourseSpec extends Specification<CourseEntity> {}

    @And(@Spec(path = "title", spec = Like.class))
    public interface ModuleSpec extends Specification<ModuleEntity> {}

    @And(@Spec(path = "title", spec = Like.class))
    public interface LessonSpec extends Specification<LessonEntity> {}
}
