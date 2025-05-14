package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.CompletedLessonDto;
import org.springframework.stereotype.Component;

@Component
public class CompletedLessonDtoMapper {

    public CompletedLessonDto toDto(CompletedLesson completedLesson){
        return new CompletedLessonDto(
          completedLesson.userId(),
          completedLesson.completedLessons()
        );
    }

    public CompletedLesson toDomain(CompletedLessonDto completedLessonDto){
        return new CompletedLesson(
          completedLessonDto.userId(),
          completedLessonDto.completedLessons()
        );
    }
}
