package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetJapaneseLessonsByLevelPublicUsecaseImpl implements GetJapaneseLessonsByLevelPublicUsecase {

    private final LessonGateway lessonGateway;

    public GetJapaneseLessonsByLevelPublicUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public List<Lesson> execute(LanguagesLevels levels, int page, int size) {
       return lessonGateway.getJapaneseLessonsByLevelPublic(levels, page, size);
    }
}
