package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
import languages.murasaki.MurasakiLanguages.core.usecases.user.DeleteUserUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public CreateUserUsecase createUserUseCase(UserGateway userGateway){
        return new CreateUserUsecaseImpl(userGateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) { return new GetAllUsersUseCaseImpl(userGateway, authenticatedUsecase);}

    @Bean
    public LoginUsecase loginUsecase(UserGateway userGateway){
        return new LoginUsecaseImpl(userGateway);
    }

    @Bean
    public UpdateUserUsecase updateUserUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {return new UpdateUserUsecaseImpl(userGateway, authenticatedUsecase);}

    @Bean
    public GetUserByIdUsecase getUserByIdUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetUserByIdUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteUserUsecase deleteUserUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteUserUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateUserPasswordUsecase updateUserPasswordUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateUserPasswordUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean UpdateUserTypeUsecase updateUserTypeUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateUserTypeUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean UpdateUserEnableUsecase updateUserEnableUsecase(UserGateway userGateway){
        return new UpdateUserEnableUsecaseImpl(userGateway);
    }

    @Bean
    public CheckoutCompletedUsecase checkoutCompletedUsecase(UserGateway userGateway){
        return new CheckoutCompletedUsecaseImpl(userGateway);
    }

    @Bean
    public SubscriptionDeletedUsecase subscriptionDeletedUsecase(UserGateway userGateway){
        return new SubscriptionDeletedUsecaseImpl(userGateway);
    }
}