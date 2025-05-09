package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.OrderGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.order.CreateOrderUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.order.CreateOrderUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeanConfiguration {

    @Bean
    public CreateOrderUsecase createOrderUsecase(OrderGateway orderGateway){
        return new CreateOrderUsecaseImpl(orderGateway);
    }
}
