package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.CreateLessonCollectionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.GetAllCollectionsUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.lessoncollection.LessonCollectionDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection.LessonCollectionDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/lesson-collection/")
public class LessonCollectionController {

    private final CreateLessonCollectionUsecase createLessonCollectionUsecase;
    private final LessonCollectionDtoMapper lessonCollectionDtoMapper;
    private final GetAllCollectionsUsecase getAllCollectionsUsecase;

    public LessonCollectionController(CreateLessonCollectionUsecase createLessonCollectionUsecase, LessonCollectionDtoMapper lessonCollectionDtoMapper, GetAllCollectionsUsecase getAllCollectionsUsecase) {
        this.createLessonCollectionUsecase = createLessonCollectionUsecase;
        this.lessonCollectionDtoMapper = lessonCollectionDtoMapper;
        this.getAllCollectionsUsecase = getAllCollectionsUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createLessonCollection(@RequestBody LessonCollectionDto lessonCollectionDto){
        lessonCollection newLessonCollection = createLessonCollectionUsecase.execute(lessonCollectionDtoMapper.toDomain(lessonCollectionDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Lesson collection criado com sucesso.");
        response.put("Lesson collection data: ", lessonCollectionDtoMapper.toDto(newLessonCollection));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<lessonCollection> getAllUsers(){
        return getAllCollectionsUsecase.execute();
    }
}
