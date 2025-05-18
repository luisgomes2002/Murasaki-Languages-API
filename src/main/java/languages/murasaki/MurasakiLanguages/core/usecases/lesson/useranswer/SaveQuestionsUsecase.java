package languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;

public interface SaveQuestionsUsecase {
    void execute(String userId, String questionId, String answer);
}
