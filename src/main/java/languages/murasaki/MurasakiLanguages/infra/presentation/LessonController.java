package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.*;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.PublishLessonInCollectionUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.LessonDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.LessonDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/lesson/")
public class LessonController {

    private final CreateLessonUsecase createLessonUsecase;
    private final PublishLessonUsecase publishLessonUsecase;
    private final LessonDtoMapper lessonDtoMapper;
    private final PublishLessonInCollectionUsecase publishLessonInCollectionUsecase;
    private final GetAllLessonUsecase getAllLessonUsecase;
    private final GetLessonByIdUsecase getLessonByIdUsecase;
    private final DeleteLessonUsecase deleteLessonUsecase;
    private final CreateBacklogUsecase createBacklogUsecase;

    public LessonController(CreateLessonUsecase createLessonUsecase, PublishLessonUsecase publishLessonUsecase, LessonDtoMapper lessonDtoMapper, PublishLessonInCollectionUsecase publishLessonInCollectionUsecase, GetAllLessonUsecase getAllLessonUsecase, GetLessonByIdUsecase getLessonByIdUsecase, DeleteLessonUsecase deleteLessonUsecase, CreateBacklogUsecase createBacklogUsecase) {
        this.createLessonUsecase = createLessonUsecase;
        this.publishLessonUsecase = publishLessonUsecase;
        this.lessonDtoMapper = lessonDtoMapper;
        this.publishLessonInCollectionUsecase = publishLessonInCollectionUsecase;
        this.getAllLessonUsecase = getAllLessonUsecase;
        this.getLessonByIdUsecase = getLessonByIdUsecase;
        this.deleteLessonUsecase = deleteLessonUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createLesson(@RequestBody LessonDto lessonDto, String userId){
        Lesson newLesson = createLessonUsecase.execute(lessonDtoMapper.toDomain(lessonDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Aula criado com sucesso.");
        response.put("Lesson data: ", lessonDtoMapper.toDto(newLesson));

        Backlog backlog = new Backlog(null, userId, "Criou uma aula: " + newLesson.title(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<Lesson> getAllLessons(){ return getAllLessonUsecase.execute(); }

    @GetMapping("{id}")
    public Lesson getLessonById(@PathVariable String id){ return getLessonByIdUsecase.execute(id); }

    @DeleteMapping("delete/{id}/{collectionId}")
    public ResponseEntity<String> deleteLesson(@PathVariable String id, @PathVariable String collectionId, String userId, String lessonName){
        deleteLessonUsecase.execute(id);
        publishLessonInCollectionUsecase.execute(collectionId, id, false);

        Backlog backlog = new Backlog(null, userId, "Deletou uma aula: " + lessonName, null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body("Aula deletado");
    }

    @PostMapping("publish/{collectionId}/{lessonId}")
    public ResponseEntity<String> updatePublishLesson(@PathVariable String collectionId, @PathVariable String lessonId, String userId){
        boolean status = publishLessonUsecase.execute(lessonId);
        String message = publishLessonInCollectionUsecase.execute(collectionId, lessonId, status);

        Backlog backlog = new Backlog(null, userId, "Atualizou um aula: " + lessonId, null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    // Update
}
