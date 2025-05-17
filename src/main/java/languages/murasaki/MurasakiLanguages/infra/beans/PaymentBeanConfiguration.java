package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.PaymentGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.payment.PaymentHandleEventUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.payment.PaymentHandleEventUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentBeanConfiguration {

    @Bean
    public PaymentHandleEventUsecase paymentHandleEventUsecase(PaymentGateway paymentGateway){
        return new PaymentHandleEventUsecaseImpl(paymentGateway);
    }
}
