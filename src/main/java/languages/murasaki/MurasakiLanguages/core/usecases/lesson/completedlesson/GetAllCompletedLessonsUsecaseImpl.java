package languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.core.gateway.CompletedLessonGateway;

import java.util.List;

public class GetAllCompletedLessonsUsecaseImpl implements GetAllCompletedLessonsUsecase{

    private final CompletedLessonGateway completedLessonGateway;

    public GetAllCompletedLessonsUsecaseImpl(CompletedLessonGateway completedLessonGateway) {
        this.completedLessonGateway = completedLessonGateway;
    }

    @Override
    public List<CompletedLesson> execute() {
        return completedLessonGateway.getAllCompletedLessons();
    }
}
