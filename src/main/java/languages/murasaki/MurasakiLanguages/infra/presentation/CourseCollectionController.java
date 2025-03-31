package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.CreateCourseCollectionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.GetAllCollectionsUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.courseCollection.CourseCollectionDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.coursecollection.CourseCollectionDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/course-collection/")
public class CourseCollectionController {

    private final CreateCourseCollectionUsecase createCourseCollectionUsecase;
    private final CourseCollectionDtoMapper courseCollectionDtoMapper;
    private final GetAllCollectionsUsecase getAllCollectionsUsecase;

    public CourseCollectionController(CreateCourseCollectionUsecase createCourseCollectionUsecase, CourseCollectionDtoMapper courseCollectionDtoMapper, GetAllCollectionsUsecase getAllCollectionsUsecase) {
        this.createCourseCollectionUsecase = createCourseCollectionUsecase;
        this.courseCollectionDtoMapper = courseCollectionDtoMapper;
        this.getAllCollectionsUsecase = getAllCollectionsUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createCourseCollection(@RequestBody CourseCollectionDto courseCollectionDto){
        CourseCollection newCourseCollection = createCourseCollectionUsecase.execute(courseCollectionDtoMapper.toDomain(courseCollectionDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Curso collection criado com sucesso.");
        response.put("Course collection data: ", courseCollectionDtoMapper.toDto(newCourseCollection));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<CourseCollection> getAllUsers(){
        return getAllCollectionsUsecase.execute();
    }
}
