package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

public interface ChangeVisibilityUsecase {

    void execute(String lessonId, Visibility visibility);
}
