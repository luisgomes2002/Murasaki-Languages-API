package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.GenerateTokenGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateTokenBeanConfiguration {

    @Bean
    public GenerateAndStoreTokenUsecase generateAndStoreTokenUsecase(GenerateTokenGateway generateTokenGateway){
        return new GenerateAndStoreTokenUsecaseImpl(generateTokenGateway);
    }

    @Bean
    public GetUserIdByTokenUsecase getUserIdByTokenUsecase(GenerateTokenGateway generateTokenGateway){
        return new GetUserIdByTokenUsecaseImpl(generateTokenGateway);
    }

    @Bean
    public DeleteTokenUsecase deleteTokenUsecase(GenerateTokenGateway generateTokenGateway){
        return new DeleteTokenUsecaseImpl(generateTokenGateway);
    }
}
