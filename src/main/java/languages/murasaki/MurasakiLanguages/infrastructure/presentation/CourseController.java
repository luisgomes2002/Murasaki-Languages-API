package languages.murasaki.MurasakiLanguages.infrastructure.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.usecases.course.CreateCourseUsecase;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.course.CourseDto;
import languages.murasaki.MurasakiLanguages.infrastructure.mapper.course.CourseDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/course/")
public class CourseController {

    private final CreateCourseUsecase createCourseUsecase;
    private final CourseDtoMapper courseDtoMapper;

    public CourseController(CreateCourseUsecase createCourseUsecase, CourseDtoMapper courseDtoMapper) {
        this.createCourseUsecase = createCourseUsecase;
        this.courseDtoMapper = courseDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createCourse(@RequestBody CourseDto courseDto){
        Course newCourse = createCourseUsecase.execute(courseDtoMapper.toDomain(courseDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso criado com sucesso.");
        response.put("Course data: ", courseDtoMapper.toDto(newCourse));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
