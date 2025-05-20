package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.AddLessonUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.GetAllCompletedLessonsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.RemoveLessonUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.GetLessonByIdUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.metrics.MetricsByLanguageUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/completed-lesson/")
public class CompletedLessonController {

    private final AddLessonUsecase addLessonUsecase;
    private final GetAllCompletedLessonsUsecase getAllCompletedLessonsUsecase;
    private final RemoveLessonUsecase removeLessonUsecase;
    private final MetricsByLanguageUsecase metricsByLanguageUsecase;
    private final GetLessonByIdUsecase getLessonByIdUsecase;

    public CompletedLessonController(AddLessonUsecase addLessonUsecase, GetAllCompletedLessonsUsecase getAllCompletedLessonsUsecase, RemoveLessonUsecase removeLessonUsecase, MetricsByLanguageUsecase metricsByLanguageUsecase, GetLessonByIdUsecase getLessonByIdUsecase) {
        this.addLessonUsecase = addLessonUsecase;
        this.getAllCompletedLessonsUsecase = getAllCompletedLessonsUsecase;
        this.removeLessonUsecase = removeLessonUsecase;
        this.metricsByLanguageUsecase = metricsByLanguageUsecase;
        this.getLessonByIdUsecase = getLessonByIdUsecase;
    }

    @PostMapping("/add/{userId}/{lessonId}")
    public String addCompletedLesson(@PathVariable String userId, @PathVariable String lessonId){
        Lesson lesson = getLessonByIdUsecase.execute(lessonId);
        addLessonUsecase.execute(userId, lessonId);

        metricsByLanguageUsecase.execute(lesson.languageType().name(), 1);

        return "Aula completa";
    }

    @DeleteMapping("/remove/{userId}/{lessonId}")
    public String removeCompletedLesson(@PathVariable String userId, @PathVariable String lessonId){
        Lesson lesson = getLessonByIdUsecase.execute(lessonId);
        removeLessonUsecase.execute(userId, lessonId);

        metricsByLanguageUsecase.execute(lesson.languageType().name(), -1);

        return "Aula não concluída";
    }

    @GetMapping("/{userId}")
    public List<CompletedLesson> getAllCompletedLessons(@PathVariable String userId){ return getAllCompletedLessonsUsecase.execute(userId);}

}


