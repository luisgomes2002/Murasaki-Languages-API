package languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonsCollectionEntity;
import org.springframework.stereotype.Component;

@Component
public class LessonCollectionEntityMapper {

    public LessonsCollectionEntity toEntity(lessonCollection lessonCollection){
        return new LessonsCollectionEntity(
            lessonCollection.id(),
            lessonCollection.languageName(),
            lessonCollection.lessonId()
        );
    }

    public lessonCollection toDomain(LessonsCollectionEntity lessonCollection){
        return new lessonCollection(
            lessonCollection.getId(),
            lessonCollection.getLanguageName(),
            lessonCollection.getLessonsId()
        );
    }
}
