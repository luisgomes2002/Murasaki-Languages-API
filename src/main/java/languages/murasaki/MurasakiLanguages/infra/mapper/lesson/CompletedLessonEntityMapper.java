package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.CompletedLessonEntity;
import org.springframework.stereotype.Component;

@Component
public class CompletedLessonEntityMapper {

    public CompletedLessonEntity toEntity(CompletedLesson completedLesson){
        return new CompletedLessonEntity(
                completedLesson.userId(),
                completedLesson.completedLessons()
        );
    }

    public CompletedLesson toDomain(CompletedLessonEntity completedLessonEntity){
        return new CompletedLesson(
          completedLessonEntity.getUserId(),
          completedLessonEntity.getCompletedLesson()
        );
    }
}
