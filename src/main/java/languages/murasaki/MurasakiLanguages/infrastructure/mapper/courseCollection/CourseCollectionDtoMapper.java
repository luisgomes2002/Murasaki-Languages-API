package languages.murasaki.MurasakiLanguages.infrastructure.mapper.courseCollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.CourseCollection.CourseCollectionDto;
import org.springframework.stereotype.Component;

@Component
public class CourseCollectionDtoMapper {

    public CourseCollectionDto toDto(CourseCollection courseCollection){
        return new CourseCollectionDto(
            courseCollection.id(),
            courseCollection.languageName(),
            courseCollection.coursesId()
        );
    }

    public CourseCollection toDomain(CourseCollectionDto courseCollectionDto){
        return new CourseCollection(
            courseCollectionDto.id(),
            courseCollectionDto.languageName(),
            courseCollectionDto.coursesId()
        );
    }
}
