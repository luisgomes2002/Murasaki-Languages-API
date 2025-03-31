package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

import java.util.List;

public interface GetAllLessonUsecase {

    List<Lesson> execute();
}
