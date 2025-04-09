package languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;

public interface GetExplanationByIdUsecase {

    Explanation execute(String id);
}
