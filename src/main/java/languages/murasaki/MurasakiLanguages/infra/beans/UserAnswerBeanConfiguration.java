package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.UserAnswerGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer.CanAnswerQuestionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer.CanAnswerQuestionUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer.SaveQuestionsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.useranswer.SaveQuestionsUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAnswerBeanConfiguration {

    @Bean
    public CanAnswerQuestionUsecase canAnswerQuestionUsecase(UserAnswerGateway userAnswerGateway){
        return new CanAnswerQuestionUsecaseImpl(userAnswerGateway);
    }

    @Bean
    public SaveQuestionsUsecase saveQuestionsUsecase(UserAnswerGateway userAnswerGateway){
        return new SaveQuestionsUsecaseImpl(userAnswerGateway);
    }
}
