package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.util.List;

public interface GetLessonsByVisibilityUsecase {

    List<Lesson> execute(Visibility visibility);
}
