package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.usecases.course.CreateCourseUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.CourseDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.course.CourseDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create/{collectionId}")
    public ResponseEntity<Map<String, Object>> createCourse(@PathVariable String collectionId, @RequestBody CourseDto courseDto){
        Course newCourse = createCourseUsecase.execute(collectionId, courseDtoMapper.toDomain(courseDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso criado com sucesso.");
        response.put("Course data: ", courseDtoMapper.toDto(newCourse));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
