    package languages.murasaki.MurasakiLanguages.infra.mapper.course;

    import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
    import languages.murasaki.MurasakiLanguages.infra.dtos.course.CourseDto;
    import org.springframework.stereotype.Component;

    @Component
    public class CourseDtoMapper {

        public CourseDto toDto(Course course){
            return new CourseDto(
                course.id(),
                course.title(),
                course.text(),
                course.explanations(),
                course.worksheets(),
                course.links(),
                course.username(),
                course.languageType(),
                course.japaneseLevels(),
                course.createAt(),
                course.updatedAt(),
                course.published(),
                course.visibility()
            );
        }

        public Course toDomain(CourseDto courseDto){
            return new Course(
                courseDto.id(),
                courseDto.title(),
                courseDto.text(),
                courseDto.explanations(),
                courseDto.worksheets(),
                courseDto.links(),
                courseDto.username(),
                courseDto.languageType(),
                courseDto.japaneseLevels(),
                courseDto.createAt(),
                courseDto.updatedAt(),
                courseDto.published(),
                courseDto.visibility()
            );
        }
    }
