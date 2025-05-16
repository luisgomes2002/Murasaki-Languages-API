package languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;

import java.util.List;

public interface GetAllCompletedLessonsUsecase {

    List<CompletedLesson> execute(String userId);
}
