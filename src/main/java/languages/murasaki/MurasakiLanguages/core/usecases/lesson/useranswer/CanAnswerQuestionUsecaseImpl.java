package languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.QuestionEligibility;
import languages.murasaki.MurasakiLanguages.core.gateway.UserAnswerGateway;

public class CanAnswerQuestionUsecaseImpl implements CanAnswerQuestionUsecase{

    private final UserAnswerGateway userAnswerGateway;

    public CanAnswerQuestionUsecaseImpl(UserAnswerGateway userAnswerGateway) {
        this.userAnswerGateway = userAnswerGateway;
    }

    @Override
    public QuestionEligibility execute(String userId, String questionId) {
       return userAnswerGateway.canAnswerQuestion(userId, questionId);
    }
}
