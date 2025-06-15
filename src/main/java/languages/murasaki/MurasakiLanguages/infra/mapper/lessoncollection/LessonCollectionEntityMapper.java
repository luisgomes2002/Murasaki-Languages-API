package languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonsCollectionEntity;
import org.springframework.stereotype.Component;

@Component
public class LessonCollectionEntityMapper {

    public LessonsCollectionEntity toEntity(LessonCollection lessonCollection){
        return new LessonsCollectionEntity(
            lessonCollection.id(),
            lessonCollection.languageName(),
            lessonCollection.status()
        );
    }

    public LessonCollection toDomain(LessonsCollectionEntity lessonCollection){
        return new LessonCollection(
            lessonCollection.getId(),
            lessonCollection.getLanguageName(),
            lessonCollection.isStatus()
        );
    }
}
