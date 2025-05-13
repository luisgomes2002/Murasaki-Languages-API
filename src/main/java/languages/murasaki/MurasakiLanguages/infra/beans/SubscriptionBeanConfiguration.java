package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.SubscriptionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.subscription.CreateSubscriptionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.subscription.CreateSubscriptionUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionBeanConfiguration {

    @Bean
    public CreateSubscriptionUsecase createSubscriptionUsecase(SubscriptionGateway subscriptionGateway){
        return new CreateSubscriptionUsecaseImpl(subscriptionGateway);
    }
}
