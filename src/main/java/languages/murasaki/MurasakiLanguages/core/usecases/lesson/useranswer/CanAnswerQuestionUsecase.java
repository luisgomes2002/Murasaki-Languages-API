package languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.QuestionEligibility;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;

public interface CanAnswerQuestionUsecase {

    QuestionEligibility execute(String userId, String questionId);
}
