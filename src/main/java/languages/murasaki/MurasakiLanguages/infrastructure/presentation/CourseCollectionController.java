package languages.murasaki.MurasakiLanguages.infrastructure.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.usecases.courseCollection.CreateCourseCollectionUsecase;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.CourseCollection.CourseCollectionDto;
import languages.murasaki.MurasakiLanguages.infrastructure.mapper.courseCollection.CourseCollectionDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/course-collection/")
public class CourseCollectionController {

    private final CreateCourseCollectionUsecase createCourseCollectionUsecase;
    private final CourseCollectionDtoMapper courseCollectionDtoMapper;

    public CourseCollectionController(CreateCourseCollectionUsecase createCourseCollectionUsecase, CourseCollectionDtoMapper courseCollectionDtoMapper) {
        this.createCourseCollectionUsecase = createCourseCollectionUsecase;
        this.courseCollectionDtoMapper = courseCollectionDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createCourseCollection(@RequestBody CourseCollectionDto courseCollectionDto){
        CourseCollection newCourseCollection = createCourseCollectionUsecase.execute(courseCollectionDtoMapper.toDomain(courseCollectionDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso collection criado com sucesso.");
        response.put("Course collection data: ", courseCollectionDtoMapper.toDto(newCourseCollection));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
