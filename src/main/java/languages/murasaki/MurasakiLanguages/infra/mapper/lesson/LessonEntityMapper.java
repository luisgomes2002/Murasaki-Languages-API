package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.LessonEntity;
import org.springframework.stereotype.Component;

@Component
public class LessonEntityMapper {

    public LessonEntity toEntity(Lesson lesson){
        return new LessonEntity(
            lesson.id(),
            lesson.title(),
            lesson.text(),
            lesson.explanations(),
            lesson.worksheets(),
            lesson.links(),
            lesson.username(),
            lesson.languageType(),
            lesson.japaneseLevels(),
            lesson.createAt(),
            lesson.updatedAt(),
            lesson.published(),
            lesson.visibility()
        );
    }

    public Lesson toDomain(LessonEntity lessonEntity){
        return new Lesson(
            lessonEntity.getId(),
            lessonEntity.getTitle(),
            lessonEntity.getText(),
            lessonEntity.getExplanations(),
            lessonEntity.getWorksheets(),
            lessonEntity.getLinks(),
            lessonEntity.getUsername(),
            lessonEntity.getLanguageType(),
            lessonEntity.getJapaneseLevels(),
            lessonEntity.getCreateAt(),
            lessonEntity.getUpdatedAt(),
            lessonEntity.isPublished(),
            lessonEntity.getVisibility()
        );
    }
}
