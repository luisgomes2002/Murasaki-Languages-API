package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.CreateLessonCollectionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.GetAllCollectionsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.UpdateLessonCollectionUsecase;
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
    private final CreateBacklogUsecase createBacklogUsecase;
    private final UpdateLessonCollectionUsecase updateLessonCollectionUsecase;

    public LessonCollectionController(CreateLessonCollectionUsecase createLessonCollectionUsecase, LessonCollectionDtoMapper lessonCollectionDtoMapper, GetAllCollectionsUsecase getAllCollectionsUsecase, CreateBacklogUsecase createBacklogUsecase, UpdateLessonCollectionUsecase updateLessonCollectionUsecase) {
        this.createLessonCollectionUsecase = createLessonCollectionUsecase;
        this.lessonCollectionDtoMapper = lessonCollectionDtoMapper;
        this.getAllCollectionsUsecase = getAllCollectionsUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
        this.updateLessonCollectionUsecase = updateLessonCollectionUsecase;
    }

    @PostMapping("create/{userId}")
    public ResponseEntity<Map<String, Object>> createLessonCollection(@RequestBody LessonCollectionDto lessonCollectionDto, @PathVariable String userId){
        LessonCollection newLessonCollection = createLessonCollectionUsecase.execute(lessonCollectionDtoMapper.toDomain(lessonCollectionDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Lesson collection criado com sucesso.");
        response.put("Lesson collection data", lessonCollectionDtoMapper.toDto(newLessonCollection));

        Backlog backlog = new Backlog(null, userId, "Criou um collection: " + newLessonCollection.languageName(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<LessonCollection> getAllUsers(){
        return getAllCollectionsUsecase.execute();
    }

    @PutMapping("update/{collectionId}/{userId}")
    public ResponseEntity<Map<String, Object>> updateLessonCollection(@PathVariable String collectionId, @PathVariable String userId, @RequestBody LessonCollection lessonCollection){
        LessonCollection updateLesson =updateLessonCollectionUsecase.execute(collectionId, lessonCollection);
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Lesson collection atualizada");
        response.put("Collection data", lessonCollectionDtoMapper.toDto(updateLesson));

        Backlog backlog = new Backlog(null, userId, "Atualizou um collection: " + lessonCollection.languageName(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
