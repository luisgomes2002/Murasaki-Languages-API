package languages.murasaki.MurasakiLanguages.infrastructure.mapper.courseCollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.courseCollection.CourseCollectionEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseCollectionEntityMapper {

    public CourseCollectionEntity toEntity(CourseCollection courseCollection){
        return new CourseCollectionEntity(
            courseCollection.id(),
            courseCollection.languageName(),
            courseCollection.coursesId()
        );
    }

    public CourseCollection toDomain(CourseCollectionEntity courseCollection){
        return new CourseCollection(
            courseCollection.getId(),
            courseCollection.getLanguageName(),
            courseCollection.getCoursesId()
        );
    }
}
