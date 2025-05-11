package languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.infra.dtos.lessoncollection.LessonCollectionDto;
import org.springframework.stereotype.Component;

@Component
public class LessonCollectionDtoMapper {

    public LessonCollectionDto toDto(lessonCollection lessonCollection){
        return new LessonCollectionDto(
            lessonCollection.id(),
            lessonCollection.languageName(),
            lessonCollection.lessonId()
        );
    }

    public lessonCollection toDomain(LessonCollectionDto lessonCollectionDto){
        return new lessonCollection(
            lessonCollectionDto.id(),
            lessonCollectionDto.languageName(),
            lessonCollectionDto.lessonId()
        );
    }
}
