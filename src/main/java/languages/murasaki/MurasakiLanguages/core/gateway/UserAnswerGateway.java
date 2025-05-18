package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.QuestionEligibility;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;

public interface UserAnswerGateway {
    void saveQuestions(String userId, String questionId, String answer);

    QuestionEligibility canAnswerQuestion(String userId, String questionId);
}
