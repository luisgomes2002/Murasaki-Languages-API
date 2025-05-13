package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.CreateUserReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.CreateUserReportUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.RemoveUserReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.RemoveUserReportUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserReportConfiguration {

    @Bean
    public CreateUserReportUsecase createUserReportUsecase(UserReportGateway userReportGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateUserReportUsecaseImpl(userReportGateway, authenticatedUsecase);
    }

    @Bean
    public RemoveUserReportUsecase removeUserReportUsecase(UserReportGateway userReportGateway){
        return new RemoveUserReportUsecaseImpl(userReportGateway);
    }
}

