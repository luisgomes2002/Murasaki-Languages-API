package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorksheetsBeanConfiguration {

    @Bean
    public CreateWorksheetsUseCase worksheetsUseCase(WorksheetsGateway worksheetsGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateWorksheetsUseCaseImpl(worksheetsGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteWorksheetsUseCase deleteWorksheetsUseCase(WorksheetsGateway worksheetsGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteWorksheetsUseCaseImpl(worksheetsGateway, authenticatedUsecase);
    }

    @Bean
    public GetWorksheetsByIdUseCase getWorksheetsByIdUseCase(WorksheetsGateway worksheetsGateway){
        return new GetWorksheetsByIdUseCaseImpl(worksheetsGateway);
    }

    @Bean
    public UpdateWorksheetsUseCase updateWorksheetsUseCase(WorksheetsGateway worksheetsGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateWorksheetsUseCaseImpl(worksheetsGateway, authenticatedUsecase);
    }
}
