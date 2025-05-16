package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.AddLessonUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.GetAllCompletedLessonsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.RemoveLessonUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/completed-lesson/")
public class CompletedLessonController {

    private final AddLessonUsecase addLessonUsecase;
    private final GetAllCompletedLessonsUsecase getAllCompletedLessonsUsecase;
    private final RemoveLessonUsecase removeLessonUsecase;

    public CompletedLessonController(AddLessonUsecase addLessonUsecase, GetAllCompletedLessonsUsecase getAllCompletedLessonsUsecase, RemoveLessonUsecase removeLessonUsecase) {
        this.addLessonUsecase = addLessonUsecase;
        this.getAllCompletedLessonsUsecase = getAllCompletedLessonsUsecase;
        this.removeLessonUsecase = removeLessonUsecase;
    }

    @PostMapping("/add/{userId}/{lessonId}")
    public String addCompletedLesson(@PathVariable String userId, @PathVariable String lessonId){
        addLessonUsecase.execute(userId, lessonId);
        return "Aula completa";
    }

    @DeleteMapping("/remove/{userId}/{lessonId}")
    public String removeCompletedLesson(@PathVariable String userId, @PathVariable String lessonId){
        removeLessonUsecase.execute(userId, lessonId);
        return "Aula não concluída";
    }

    @GetMapping("/{userId}")
    public List<CompletedLesson> getAllCompletedLessons(@PathVariable String userId){ return getAllCompletedLessonsUsecase.execute(userId);}

}


