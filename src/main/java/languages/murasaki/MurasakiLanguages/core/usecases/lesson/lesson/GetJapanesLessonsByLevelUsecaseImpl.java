package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetJapanesLessonsByLevelUsecaseImpl implements GetJapanesLessonsByLevelUsecase{

    private final LessonGateway lessonGateway;

    public GetJapanesLessonsByLevelUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute(JapaneseLevels level, int page, int size) {
        return lessonGateway.getJapanesLessonsByLevel(level, page, size);
    }
}
