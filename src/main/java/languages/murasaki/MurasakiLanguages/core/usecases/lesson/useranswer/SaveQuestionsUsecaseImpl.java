package languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswersLog;
import languages.murasaki.MurasakiLanguages.core.gateway.UserAnswerGateway;

public class SaveQuestionsUsecaseImpl implements SaveQuestionsUsecase{

    private final UserAnswerGateway userAnswerGateway;

    public SaveQuestionsUsecaseImpl(UserAnswerGateway userAnswerGateway) {
        this.userAnswerGateway = userAnswerGateway;
    }

    @Override
    public void execute(String userId, String questionId, String answer) {
        userAnswerGateway.saveQuestions(userId, questionId, answer);
    }
}
