package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.*;
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
    private final GetAllLessonUsecase getAllLessonUsecase;
    private final GetLessonByIdUsecase getLessonByIdUsecase;
    private final DeleteLessonUsecase deleteLessonUsecase;
    private final CreateBacklogUsecase createBacklogUsecase;
    private final UpdateLessonUsecase updateLessonUsecase;
    private final GetLessonsByPublishedTrueUsecase getLessonsByPublishedTrueUsecase;
    private final GetLessonsByPublishedOrNotUsecase getLessonsByPublishedOrNotUsecase;
    private final GetLessonsByVisibilityUsecase getLessonsByVisibilityUsecase;
    private final GetPublicLessonsUsecase getPublicLessonsUsecase;
    private final GetJapaneseLessonsByLevelPublicUsecase getJapaneseLessonsByLevelPublicUsecase;
    private final GetJapaneseLessonsByLevelUsecase getJapaneseLessonsByLevelUsecase;
    private final ChangeVisibilityUsecase changeVisibilityUsecase;
    private final GetJapanesePublicLessonsUsecase getJapanesePublicLessonsUsecase;
    private final GetAllJapaneseLessonsUsecase getAllJapaneseLessonsUsecase;

    public LessonController(CreateLessonUsecase createLessonUsecase, PublishLessonUsecase publishLessonUsecase, LessonDtoMapper lessonDtoMapper, GetAllLessonUsecase getAllLessonUsecase, GetLessonByIdUsecase getLessonByIdUsecase, DeleteLessonUsecase deleteLessonUsecase, CreateBacklogUsecase createBacklogUsecase, UpdateLessonUsecase updateLessonUsecase, GetLessonsByPublishedTrueUsecase getLessonsByPublishedTrueUsecase, GetLessonsByPublishedOrNotUsecase getLessonsByPublishedOrNotUsecase, GetLessonsByVisibilityUsecase getLessonsByVisibilityUsecase, GetPublicLessonsUsecase getPublicLessonsUsecase, GetJapaneseLessonsByLevelPublicUsecase getJapaneseLessonsByLevelPublicUsecase, GetJapaneseLessonsByLevelUsecase getJapaneseLessonsByLevelUsecase, ChangeVisibilityUsecase changeVisibilityUsecase, GetJapanesePublicLessonsUsecase getJapanesePublicLessonsUsecase, GetAllJapaneseLessonsUsecase getAllJapaneseLessonsUsecase) {
        this.createLessonUsecase = createLessonUsecase;
        this.publishLessonUsecase = publishLessonUsecase;
        this.lessonDtoMapper = lessonDtoMapper;
        this.getAllLessonUsecase = getAllLessonUsecase;
        this.getLessonByIdUsecase = getLessonByIdUsecase;
        this.deleteLessonUsecase = deleteLessonUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
        this.updateLessonUsecase = updateLessonUsecase;
        this.getLessonsByPublishedTrueUsecase = getLessonsByPublishedTrueUsecase;
        this.getLessonsByPublishedOrNotUsecase = getLessonsByPublishedOrNotUsecase;
        this.getLessonsByVisibilityUsecase = getLessonsByVisibilityUsecase;
        this.getPublicLessonsUsecase = getPublicLessonsUsecase;
        this.getJapaneseLessonsByLevelPublicUsecase = getJapaneseLessonsByLevelPublicUsecase;
        this.getJapaneseLessonsByLevelUsecase = getJapaneseLessonsByLevelUsecase;
        this.changeVisibilityUsecase = changeVisibilityUsecase;
        this.getJapanesePublicLessonsUsecase = getJapanesePublicLessonsUsecase;
        this.getAllJapaneseLessonsUsecase = getAllJapaneseLessonsUsecase;
    }

    @PostMapping("create/{userId}")
    public ResponseEntity<Map<String, Object>> createLesson(@RequestBody LessonDto lessonDto, @PathVariable String userId){
        Lesson newLesson = createLessonUsecase.execute(lessonDtoMapper.toDomain(lessonDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Aula criada com sucesso.");
        response.put("Lesson data", lessonDtoMapper.toDto(newLesson));

        Backlog backlog = new Backlog(null, userId, "Criou uma aula: " + newLesson.title(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<Lesson> getAllLessons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return getAllLessonUsecase.execute(page, size);
    }

    @GetMapping("visibility/{visibility}")
    public List<Lesson> getLessonsByVisibility(@PathVariable String visibility, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getLessonsByVisibilityUsecase.execute(Visibility.valueOf(visibility.toUpperCase()), page, size);
    }

    @GetMapping("published/{published}")
    public List<Lesson> getLessonsByPublishedOrNot(@PathVariable boolean published, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getLessonsByPublishedOrNotUsecase.execute(published, page, size);
    }

    @GetMapping("public")
    public List<Lesson> getPublicLessons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getPublicLessonsUsecase.execute(page, size);
    }

    @GetMapping("japanese/public/")
    public List<Lesson> getJapanesePublicLessons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getJapanesePublicLessonsUsecase.execute(page, size);
    }

    @GetMapping("published-true")
    public List<Lesson> getLessonsByPublishedTrue(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getLessonsByPublishedTrueUsecase.execute(page, size);
    }

    @GetMapping("all-japanese/published/")
    public List<Lesson> getAllJapaneseLessonsByPublishedTrue(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getAllJapaneseLessonsUsecase.execute(page, size);
    }

    @GetMapping("{id}")
    public Lesson getLessonById(@PathVariable String id){ return getLessonByIdUsecase.execute(id); }

    @GetMapping("japanese-level-public/{level}")
    public List<Lesson> getByJapaneseLevelPublic(@PathVariable LanguagesLevels level, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) { return getJapaneseLessonsByLevelPublicUsecase.execute(level, page, size);}

    @GetMapping("japanese-level/{level}")
    public List<Lesson> getByJapaneseLevel(@PathVariable LanguagesLevels level, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) { return getJapaneseLessonsByLevelUsecase.execute(level, page, size);}

    @DeleteMapping("delete/{id}/{userId}/{lessonName}")
    public ResponseEntity<String> deleteLesson(@PathVariable String id, @PathVariable String userId, @PathVariable String lessonName){
        deleteLessonUsecase.execute(id);

        Backlog backlog = new Backlog(null, userId, "Deletou uma aula: " + lessonName, null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body("Aula deletado");
    }

    @PutMapping("update/{lessonId}/{userId}")
    public ResponseEntity<Map<String, Object>> updateLesson(@PathVariable String lessonId, @PathVariable String userId, @RequestBody LessonDto lessonDto){
        Lesson lesson = updateLessonUsecase.execute(lessonId, lessonDtoMapper.toDomain(lessonDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Aula atualizada");
        response.put("Lesson data", lessonDtoMapper.toDto(lesson));

        Backlog backlog = new Backlog(null, userId, "Atualizou o aula: " + lesson.title(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update/lesson-visibility/{lessonId}/{userId}")
    public String updateLessonVisibility(@PathVariable String lessonId, @RequestBody Visibility visibility, @PathVariable String userId){
        changeVisibilityUsecase.execute(lessonId, visibility);

        Backlog backlog = new Backlog(null, userId, "Atualizou a visibilidade da aula: " + lessonId, null);
        createBacklogUsecase.execute(backlog);


        return "Aula atualizada";
    }
}
