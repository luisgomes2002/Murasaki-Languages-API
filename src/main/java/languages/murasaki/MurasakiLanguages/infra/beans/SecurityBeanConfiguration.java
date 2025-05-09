package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.SecurityGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityBeanConfiguration {

    @Bean
    public AuthenticatedUsecase authenticatedUsecase(SecurityGateway securityGateway){
        return new AuthenticatedUsecaseImpl(securityGateway);
    }
}
