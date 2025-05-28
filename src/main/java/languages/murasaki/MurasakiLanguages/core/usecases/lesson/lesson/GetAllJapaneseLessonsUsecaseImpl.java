package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetAllJapaneseLessonsUsecaseImpl implements GetAllJapaneseLessonsUsecase{

    private final LessonGateway lessonGateway;

    public GetAllJapaneseLessonsUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute(int page, int size) {
        return lessonGateway.getAllJapaneseLessons(page, size);
    }
}
