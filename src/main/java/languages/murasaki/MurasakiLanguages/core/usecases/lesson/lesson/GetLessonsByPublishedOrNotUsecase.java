package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

import java.util.List;

public interface GetLessonsByPublishedOrNotUsecase {

    List<Lesson> execute(boolean published, int page, int size);
}
