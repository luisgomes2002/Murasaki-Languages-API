package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;

import java.util.List;

public interface GetJapaneseLessonsByLevelUsecase {
    List<Lesson> execute(LanguagesLevels level, int page, int size);
}
