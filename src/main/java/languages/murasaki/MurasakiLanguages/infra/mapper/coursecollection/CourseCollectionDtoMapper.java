package languages.murasaki.MurasakiLanguages.infra.mapper.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.infra.dtos.CourseCollection.CourseCollectionDto;
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
