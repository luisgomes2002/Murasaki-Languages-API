package languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.infra.dtos.lessoncollection.LessonCollectionDto;
import org.springframework.stereotype.Component;

@Component
public class LessonCollectionDtoMapper {

    public LessonCollectionDto toDto(LessonCollection lessonCollection){
        return new LessonCollectionDto(
            lessonCollection.id(),
            lessonCollection.languageName(),
            lessonCollection.status()
        );
    }

    public LessonCollection toDomain(LessonCollectionDto lessonCollectionDto){
        return new LessonCollection(
            lessonCollectionDto.id(),
            lessonCollectionDto.languageName(),
            lessonCollectionDto.status()
        );
    }
}
