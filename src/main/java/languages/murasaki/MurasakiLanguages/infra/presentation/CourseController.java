package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.usecases.course.CreateCourseUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.course.PublishCourseUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.PublishCourseInCollectionUsecase;
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
    private final PublishCourseUsecase publishCourseUsecase;
    private final CourseDtoMapper courseDtoMapper;
    private final PublishCourseInCollectionUsecase publishCourseInCollectionUsecase;

    public CourseController(CreateCourseUsecase createCourseUsecase, PublishCourseUsecase publishCourseUsecase, CourseDtoMapper courseDtoMapper, PublishCourseInCollectionUsecase publishCourseInCollectionUsecase) {
        this.createCourseUsecase = createCourseUsecase;
        this.publishCourseUsecase = publishCourseUsecase;
        this.courseDtoMapper = courseDtoMapper;
        this.publishCourseInCollectionUsecase = publishCourseInCollectionUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createCourse(@RequestBody CourseDto courseDto){
        Course newCourse = createCourseUsecase.execute(courseDtoMapper.toDomain(courseDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso criado com sucesso.");
        response.put("Course data: ", courseDtoMapper.toDto(newCourse));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("publish/{collectionId}/{courseId}")
    public ResponseEntity<String> updatePublishCourse(@PathVariable String collectionId, @PathVariable String courseId){
        publishCourseInCollectionUsecase.execute(collectionId, courseId);
        String status = publishCourseUsecase.execute(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
