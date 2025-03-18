package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CreateUserUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CreateUserUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.user.LoginUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.LoginUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateUserUsecase createUserUseCase(UserGateway userGateway){
        return new CreateUserUsecaseImpl(userGateway);
    }

    @Bean
    public LoginUsecase loginUsecase(UserGateway userGateway){
        return new LoginUsecaseImpl(userGateway);
    }
}
