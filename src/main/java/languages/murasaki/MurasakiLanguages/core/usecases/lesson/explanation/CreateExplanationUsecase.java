package languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;

public interface CreateExplanationUsecase {

    Explanation execute(Explanation explanation);
}
