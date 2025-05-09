package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.email.SendEmailUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.email.SendEmailUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailBeanConfiguration {

    @Bean
    public SendEmailUsecase sendEmailUsecase(EmailGateway emailGateway){
        return new SendEmailUsecaseImpl(emailGateway);
    }
}
