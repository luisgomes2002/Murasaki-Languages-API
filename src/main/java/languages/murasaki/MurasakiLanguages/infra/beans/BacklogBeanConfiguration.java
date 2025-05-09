package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.BacklogGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BacklogBeanConfiguration {

    @Bean
    public CreateBacklogUsecase createBacklogUsecase(BacklogGateway backlogGateway){
        return new CreateBacklogUsecaseImpl(backlogGateway);
    }

    @Bean
    public GetAllBacklogUsecase getAllBacklogUsecase(BacklogGateway backlogGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllBacklogUsecaseImpl(backlogGateway, authenticatedUsecase);
    }
}
