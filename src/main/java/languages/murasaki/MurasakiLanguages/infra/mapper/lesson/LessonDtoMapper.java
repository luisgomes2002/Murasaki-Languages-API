    package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

    import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
    import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.LessonDto;
    import org.springframework.stereotype.Component;

    @Component
    public class LessonDtoMapper {

        public LessonDto toDto(Lesson lesson){
            return new LessonDto(
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

        public Lesson toDomain(LessonDto lessonDto){
            return new Lesson(
                lessonDto.id(),
                lessonDto.title(),
                lessonDto.text(),
                lessonDto.explanations(),
                lessonDto.worksheets(),
                lessonDto.links(),
                lessonDto.name(),
                lessonDto.languageType(),
                lessonDto.languagesLevels(),
                lessonDto.createAt(),
                lessonDto.updatedAt(),
                lessonDto.published(),
                lessonDto.visibility(),
                lessonDto.ankiLink(),
                lessonDto.thumbLink()
            );
        }
    }
