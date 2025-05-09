package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.ExplanationGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExplanationBeanConfiguration {

    @Bean
    public CreateExplanationUsecase createExplanationUsecase(ExplanationGateway explanationGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateExplanationUsecaseImpl(explanationGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteExplanationUsecase deleteExplanationUsecase(ExplanationGateway explanationGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteExplanationUsecaseImpl(explanationGateway, authenticatedUsecase);
    }

    @Bean
    public GetExplanationByIdUsecase getExplanationByIdUsecase(ExplanationGateway explanationGateway){
        return new GetExplanationUsecaseImpl(explanationGateway);
    }

    @Bean
    public UpdateExplanationUsecase updateExplanationUsecase(ExplanationGateway explanationGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateExplanationUsecaseImpl(explanationGateway, authenticatedUsecase);
    }
}
