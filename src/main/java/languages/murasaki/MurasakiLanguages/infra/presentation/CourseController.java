package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.usecases.course.course.*;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.PublishCourseInCollectionUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.CourseDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.course.CourseDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/course/")
public class CourseController {

    private final CreateCourseUsecase createCourseUsecase;
    private final PublishCourseUsecase publishCourseUsecase;
    private final CourseDtoMapper courseDtoMapper;
    private final PublishCourseInCollectionUsecase publishCourseInCollectionUsecase;
    private final GetAllCoursesUsecase getAllCoursesUsecase;
    private final GetCourseByIdUsecase getCourseByIdUsecase;
    private final DeleteCourseUsecase deleteCourseUsecase;

    public CourseController(CreateCourseUsecase createCourseUsecase, PublishCourseUsecase publishCourseUsecase, CourseDtoMapper courseDtoMapper, PublishCourseInCollectionUsecase publishCourseInCollectionUsecase, GetAllCoursesUsecase getAllCoursesUsecase, GetCourseByIdUsecase getCourseByIdUsecase, DeleteCourseUsecase deleteCourseUsecase) {
        this.createCourseUsecase = createCourseUsecase;
        this.publishCourseUsecase = publishCourseUsecase;
        this.courseDtoMapper = courseDtoMapper;
        this.publishCourseInCollectionUsecase = publishCourseInCollectionUsecase;
        this.getAllCoursesUsecase = getAllCoursesUsecase;
        this.getCourseByIdUsecase = getCourseByIdUsecase;
        this.deleteCourseUsecase = deleteCourseUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createCourse(@RequestBody CourseDto courseDto){
        Course newCourse = createCourseUsecase.execute(courseDtoMapper.toDomain(courseDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso criado com sucesso.");
        response.put("Course data: ", courseDtoMapper.toDto(newCourse));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){ return getAllCoursesUsecase.execute(); }

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable String id){ return getCourseByIdUsecase.execute(id); }

    @DeleteMapping("delete/{id}/{collectionId}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id,@PathVariable String collectionId){
        deleteCourseUsecase.deleteCourse(id);
        publishCourseInCollectionUsecase.execute(collectionId, id, false);
        return ResponseEntity.status(HttpStatus.OK).body("Course deletado");
    }

    @PostMapping("publish/{collectionId}/{courseId}")
    public ResponseEntity<String> updatePublishCourse(@PathVariable String collectionId, @PathVariable String courseId){
        boolean status = publishCourseUsecase.execute(courseId);
        String message = publishCourseInCollectionUsecase.execute(collectionId, courseId, status);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    // Update
}
