package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.plans.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlansBeanConfiguration {

    @Bean
    public CreatePlanUsecase createPlanUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreatePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public DeletePlanUsecase deletePlanUsecase (PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeletePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllPlansUsecase getAllPlansUsecase(PlansGateway plansGateway){
        return new GetAllPlansUsecaseImpl(plansGateway);
    }

    @Bean
    public GetPlanByIdUsecase getPlanByIdUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetPlanByIdUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public UpdatePlanUsecase updatePlanUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdatePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }
}
