package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetPublicLessonsUsecaseImpl implements GetPublicLessonsUsecase{

    private final LessonGateway lessonGateway;

    public GetPublicLessonsUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute() {
        return lessonGateway.getPublicLessons();
    }
}
