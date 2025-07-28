package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;

import java.util.List;

public class GetJapaneseLessonsByLevelUsecaseImpl implements GetJapaneseLessonsByLevelUsecase {

    private final LessonGateway lessonGateway;

    public GetJapaneseLessonsByLevelUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public Pagination<Lesson> execute(LanguagesLevels level, int page, int size) {
        return lessonGateway.getJapaneseLessonsByLevel(level, page, size);
    }
}
