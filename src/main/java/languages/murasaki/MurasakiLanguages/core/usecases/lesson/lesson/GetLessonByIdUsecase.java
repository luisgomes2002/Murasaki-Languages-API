package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

public interface GetLessonByIdUsecase {

    Lesson execute(String id);
}
