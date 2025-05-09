package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetLessonsByPublishedTrueUsecaseImpl implements  GetLessonsByPublishedTrueUsecase{

    private final LessonGateway lessonGateway;

    public GetLessonsByPublishedTrueUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute() {
        return lessonGateway.getLessonsByPublishedTrue();
    }
}
