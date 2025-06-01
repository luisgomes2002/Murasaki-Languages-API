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
            lesson.name(),
            lesson.languageType(),
            lesson.languagesLevels(),
            lesson.createAt(),
            lesson.updatedAt(),
            lesson.published(),
            lesson.visibility(),
            lesson.ankiLink(),
            lesson.thumbLink()
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
            lessonEntity.getName(),
            lessonEntity.getLanguageType(),
            lessonEntity.getLanguagesLevels(),
            lessonEntity.getCreateAt(),
            lessonEntity.getUpdatedAt(),
            lessonEntity.isPublished(),
            lessonEntity.getVisibility(),
            lessonEntity.getAnkiLink(),
            lessonEntity.getThumbLink()
        );
    }
}
