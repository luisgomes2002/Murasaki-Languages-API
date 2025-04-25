package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

public interface UpdateLessonUsecase {

    Lesson execute(String id, Lesson lesson);
}
