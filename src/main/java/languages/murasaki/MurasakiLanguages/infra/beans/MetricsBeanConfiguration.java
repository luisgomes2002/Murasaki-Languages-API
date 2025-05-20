package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.metrics.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsBeanConfiguration {

    @Bean
    public MetricsDeletedUserUsecase metricsDeletedUserUsecase(MetricsGateway metricsGateway){
        return new MetricsDeletedUserUsecaseImpl(metricsGateway);
    }

    @Bean
    public MetricsActiveUsersUsecase metricsActiveUsersUsecase(MetricsGateway metricsGateway){
        return new MetricsActiveUsersUsecaseImpl(metricsGateway);
    }

    @Bean
    public MetricsBanUserUsecase metricsBanUserUsecase(MetricsGateway metricsGateway){
        return new MetricsBanUserUsecaseImpl(metricsGateway);
    }

    @Bean
    public MetricsCreateUserUsecase metricsCreateUserUsecase(MetricsGateway metricsGateway){
        return new MetricsCreateUserUsecaseImpl(metricsGateway);
    }

    @Bean
    public GetMetricByDateUsecase getMetricByDateUsecase(MetricsGateway metricsGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetMetricByDateUsecaseImpl(metricsGateway, authenticatedUsecase);
    }

    @Bean
    public MetricsUpdateUserAgeUsecase metricsUpdateUserAgeUsecase(MetricsGateway metricsGateway){
        return new MetricsUpdateUserAgeUsecaseImpl(metricsGateway);
    }

    @Bean
    public MetricsUpdateUserGenderUsecase metricsUpdateUserGenderUsecase(MetricsGateway metricsGateway){
        return new MetricsUpdateUserGenderUsecaseImpl(metricsGateway);
    }

    @Bean
    public AddMetricsToListUsecase addMetricsToListUsecase(MetricsGateway metricsGateway){
        return new AddMetricsToListUsecaseImpl(metricsGateway);
    }

    @Bean
    public GetAllMetricsDateUsecase getAllMetricsDateUsecase(MetricsGateway metricsGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllMetricsDateUsecaseImpl(metricsGateway, authenticatedUsecase);
    }

    @Bean
    public MetricsByLanguageUsecase metricsByLanguageUsecase(MetricsGateway metricsGateway){
        return new MetricsByLanguageUsecaseImpl(metricsGateway);
    }
}
