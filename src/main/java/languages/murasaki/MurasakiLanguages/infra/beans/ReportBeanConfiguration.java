package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.report.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportBeanConfiguration {

    @Bean
    public CreateReportUsecase createReportUsecase(ReportGateway reportGateway){
        return new CreateReportUsecaseImpl(reportGateway);
    }

    @Bean
    public GetAllReportsUsecase getAllReportsUsecase(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllReportsUsecaseImpl(reportGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateReportStatusUsecase updateReportStatusUsecase(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateReportStatusUsecaseImpl(reportGateway, authenticatedUsecase);
    }
}
