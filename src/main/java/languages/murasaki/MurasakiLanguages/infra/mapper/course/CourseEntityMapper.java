package languages.murasaki.MurasakiLanguages.infra.mapper.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityMapper {

    public CourseEntity toEntity(Course course){
        return new CourseEntity(
            course.id(),
            course.title(),
            course.text(),
            course.links(),
            course.username(),
            course.languageType(),
            course.japaneseLevels(),
            course.createAt(),
            course.updatedAt()
        );
    }

    public Course toDomain(CourseEntity courseEntity){
        return new Course(
            courseEntity.getId(),
            courseEntity.getTitle(),
            courseEntity.getText(),
            courseEntity.getLinks(),
            courseEntity.getUsername(),
            courseEntity.getLanguageType(),
            courseEntity.getJapaneseLevels(),
            courseEntity.getCreateAt(),
            courseEntity.getUpdatedAt()
        );
    }
}
