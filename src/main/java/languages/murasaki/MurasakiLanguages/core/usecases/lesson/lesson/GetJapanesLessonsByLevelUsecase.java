package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;

import java.util.List;

public interface GetJapanesLessonsByLevelUsecase {

    List<Lesson> execute(JapaneseLevels levels, int page, int size);
}
