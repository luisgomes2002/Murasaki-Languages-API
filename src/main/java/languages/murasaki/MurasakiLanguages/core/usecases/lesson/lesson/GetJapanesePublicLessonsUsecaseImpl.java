package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetJapanesePublicLessonsUsecaseImpl implements GetJapanesePublicLessonsUsecase {

    private final LessonGateway lessonGateway;

    public GetJapanesePublicLessonsUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute(int page, int size) {
        return lessonGateway.getJapanesePublicLessons(page, size);
    }
}
