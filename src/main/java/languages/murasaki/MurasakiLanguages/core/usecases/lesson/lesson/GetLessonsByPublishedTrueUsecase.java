package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

import java.util.List;

public interface GetLessonsByPublishedTrueUsecase {

    List<Lesson> execute(int page, int size);
}
