package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.email.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailBeanConfiguration {

    @Bean
    public SendEmailUsecase sendEmailUsecase(EmailGateway emailGateway){
        return new SendEmailUsecaseImpl(emailGateway);
    }

    @Bean
    public CompletedSubscriptionUsecase completedSubscriptionUsecase(EmailGateway emailGateway){
        return new CompletedSubscriptionUsecaseImpl(emailGateway);
    }

    @Bean
    public DeletedSubscriptionUsecase deletedSubscriptionUsecase(EmailGateway emailGateway){
        return new DeletedSubscriptionUsecaseImpl(emailGateway);
    }

    @Bean
    public RenewedSubscriptionUsecase renewedSubscriptionUsecase(EmailGateway emailGateway){
        return new RenewedSubscriptionUsecaseImpl(emailGateway);
    }
}
