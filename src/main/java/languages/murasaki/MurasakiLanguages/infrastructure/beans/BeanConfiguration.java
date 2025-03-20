package languages.murasaki.MurasakiLanguages.infrastructure.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
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

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway) {return new GetAllUsersUseCaseImpl(userGateway);}
}
