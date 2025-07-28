package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;

import java.util.List;

public interface GetJapaneseLessonsByLevelUsecase {
    Pagination<Lesson> execute(LanguagesLevels level, int page, int size);
}
